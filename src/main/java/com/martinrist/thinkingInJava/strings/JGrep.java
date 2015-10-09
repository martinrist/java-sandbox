package com.martinrist.thinkingInJava.strings;

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JGrep {

    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Usage: java JGrep path regex [flags]");
            System.exit(0);
        }

        int flags = 0;
        if (args.length > 2) {
            flags = parseFlags(Arrays.copyOfRange(args, 2, args.length));
        }

        Pattern p = Pattern.compile(args[1], flags);

        String path = args[0];

        if (Files.isDirectory(Paths.get(path))) {
            searchDirectory(p, path);
        } else {
            System.out.println("Searching file " + path);
            searchFile(p, new File(path));
        }

    }

    private static void searchDirectory(Pattern p, String path) throws FileNotFoundException {

        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (Files.isDirectory(file.toPath())) {
                searchDirectory(p, file.getPath());
            } else {
                System.out.println("Searching file " + file.getPath());
                searchFile(p, file);
                System.out.println();
            }
        }

    }

    private static void searchFile(Pattern p, File file) throws FileNotFoundException {

        int index = 0;
        Matcher m = p.matcher("");
        for (String line : getFileContents(file)) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }

    private static int parseFlags(String... flags) {

        int result = 0;
        for (String flag : flags) {
            result = result | parseFlag(flag);
        }
        return result;

    }

    private static int parseFlag(String flag) {

        try {
            Field f = Pattern.class.getDeclaredField(flag);
            return f.getInt(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return 0;
        }

    }

    public static List<String> getFileContents(File file) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.lines().collect(Collectors.toList());

    }

}
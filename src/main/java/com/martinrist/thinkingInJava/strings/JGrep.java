package com.martinrist.thinkingInJava.strings;

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JGrep {

    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]);

        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : getFileContents(args[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }


    public static List<String> getFileContents(String filename) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.lines().collect(Collectors.toList());

    }

}



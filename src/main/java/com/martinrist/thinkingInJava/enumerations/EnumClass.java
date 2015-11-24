package com.martinrist.thinkingInJava.enumerations;

public class EnumClass {

    public static void main(String[] args) {

        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println("compareTo(CRAWLING): " + s.compareTo(Shrubbery.CRAWLING));
            System.out.println("equals(CRAWLING): " + s.equals(Shrubbery.CRAWLING));
            System.out.println("== CRAWLING: " + (s == Shrubbery.CRAWLING));
            System.out.println("getDeclaringClass(): " + s.getDeclaringClass());
            System.out.println("getClass().getSimpleName(): " + s.getClass().getSimpleName());
            System.out.println("getClass.getSuperclass().getSimpleName(): " + s.getClass().getSuperclass().getSimpleName());
            System.out.println("name(): " + s.name());
            System.out.println("--------------");
        }
    }
}




enum Shrubbery { GROUND, CRAWLING, HANGING }
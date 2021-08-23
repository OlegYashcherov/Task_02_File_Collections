package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortWithComparator {

    public static final String SRC = "Pushkin.txt";

    public static void main(String[] args) {

        StringBuilder etalonString = new StringBuilder();

        try(FileReader in = new FileReader(SRC);
            BufferedReader reader = new BufferedReader(in)) {
            while (reader.ready()) {
                etalonString.append(reader.readLine().toUpperCase());
                etalonString.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] pushkinArray = etalonString.toString().replaceAll("[:|;|\\.|,|-]","").replaceAll("(\\n+)|(\\s+)"," ").split(" ");
        System.out.println(Arrays.toString(pushkinArray));

        Set<String> set = new TreeSet<>(new MyComparator());
        for (String element : pushkinArray) {
            set.add(element);
        }

        System.out.println("\nВыводим слова сортированные по длине, а затем по лексике\n");
        for (String element : set) {
            System.out.println(element);
        }

    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            }
            return o1.compareTo(o2);
        }
    }
}

package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DifferentWordCount {

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

        Set<String> set = new HashSet<>(Arrays.asList(pushkinArray));
        System.out.println("В стихотворении " + set.size() + " различных слов");
    }
}

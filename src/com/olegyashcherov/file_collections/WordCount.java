package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {

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

        String[] pushkin = etalonString.toString().replaceAll("[:|;|\\.|,|-]","").replaceAll("(\\n+)|(\\s+)"," ").split(" ");
        System.out.println(Arrays.toString(pushkin));

/*
        Set<String> set = new HashSet<>(Arrays.asList(pushkin));
        System.out.println("В стихотворении " + set.size() + " различных слов");
*/
        Map<String, Integer> map = new HashMap<>();
        for (String word : pushkin) {
            Integer n = map.get(word);
            n = (n == null) ? 1 : ++n;
            map.put(word, n);
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}

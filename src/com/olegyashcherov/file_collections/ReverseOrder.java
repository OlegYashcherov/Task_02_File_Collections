package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReverseOrder {

    public static final String SRC = "Pushkin.txt";

    public static void main(String[] args) {

        List<String> pushkinList = new ArrayList<>();

        try (FileReader in = new FileReader(SRC);
             BufferedReader reader = new BufferedReader(in)) {
            while (reader.ready()) {
                pushkinList.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nВывод стихотворения в обратном порядке:\n");
        for (int i = pushkinList.size() - 1; i >= 0; i--) {
            System.out.println(pushkinList.get(i));
        }

    }
}

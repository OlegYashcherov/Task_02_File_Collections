package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputLineNumber {
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

        String initialMessage = "\nВведите номер строки для вывода:\n" +
                "от 1 до " + pushkinList.size() + "\n" +
                "или любой символ для выхода из программы\n";
        System.out.println(initialMessage);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i > 0 && i <= pushkinList.size()) {
                    System.out.println("\n"+pushkinList.get(i-1));
                } else {
                    System.out.println("\nНеверный номер строки! Попробуйте ещё раз\n");
                }
            } else {
                System.out.println("Game over");
                return;
            }
        }
    }
}

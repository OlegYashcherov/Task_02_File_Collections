package com.olegyashcherov.file_collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReverseOrderIterator {

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

        ReverseList<String> newPushkinList = new ReverseList<>(pushkinList);

        // Вывод листа в обратном порядке
        for (String line : newPushkinList) {
            System.out.println(line);
        }

    }

    public static class ReverseList<Type> implements Iterable<Type> {

        private final List<Type> arrayList;
        private final int currentSize;

        public ReverseList(List<Type> list) {
            this.arrayList = list;
            this.currentSize = arrayList.size();
        }

        @Override
        public Iterator<Type> iterator() {
            return new Iterator<>() {

                private int currentIndex = currentSize - 1;

                @Override
                public boolean hasNext() {
                    return currentIndex >= 0 && arrayList.get(currentIndex) != null;
                }

                @Override
                public Type next() {
                    return arrayList.get(currentIndex--);
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

}

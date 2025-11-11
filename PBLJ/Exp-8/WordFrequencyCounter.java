// File: WordFrequencyCounter.java
import java.util.*;
import java.util.concurrent.*;

public class WordFrequencyCounter {
    private static ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String[] paragraphs = {
            "Java is powerful and Java is robust",
            "Multithreading in Java improves performance and efficiency",
            "ConcurrentHashMap provides thread safety in Java",
            "Performance and efficiency are important in Java"
        };

        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            final int index = i;
            threads[i] = new Thread(() -> processParagraph(paragraphs[index]), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Sort by frequency (descending)
        wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    private static void processParagraph(String paragraph) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
            System.out.println(Thread.currentThread().getName() + " updating: " + word);
        }
    }
}

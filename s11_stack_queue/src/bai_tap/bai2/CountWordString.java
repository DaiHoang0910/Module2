package bai_tap.bai2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWordString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Input string");
        str = sc.nextLine();
        System.out.println(str);
        System.out.println("\nList the number of occurrences of the words.");
        Map<String, Integer> workMap = countWords(str);
        for (String key : workMap.keySet()) {
            System.out.println(key + ": " + workMap.get(key));
        }
    }

    public static Map<String, Integer> countWords(String str) {
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (str == null) {
            return wordMap;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        addWord(wordMap, sb);
        return wordMap;
    }

    private static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }

}

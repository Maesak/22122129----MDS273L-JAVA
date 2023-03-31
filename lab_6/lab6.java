package lab_6;


import java.util.*;
import java.io.*;

public class lab6 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "text.txt";
        String content = readFile(filename);
        

        HashMap<Character, Integer> vowelsCount = countVowels(content);
        System.out.println("Vowels and their count: " + vowelsCount);


        HashMap<Character, Integer> digitsCount = countDigits(content);
        System.out.println("Digits and their count: " + digitsCount);


        ArrayList<String> topFiveWords = findTopNWords(content, 5, true);
        System.out.println("Top five repeated words: " + topFiveWords);

 
        ArrayList<String> leastFiveWords = findTopNWords(content, 5, false);
        System.out.println("Least five repeated words: " + leastFiveWords);

        
        ArrayList<Character> topFiveChars = findTopNChars(content, 5, true);
        System.out.println("Top five repeated characters: " + topFiveChars);

       
        ArrayList<Character> leastFiveChars = findTopNChars(content, 5, false);
        System.out.println("Least five repeated characters: " + leastFiveChars);
    }

    public static String readFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine() + "\n");
        }
        scanner.close();
        return sb.toString();
    }

    public static HashMap<Character, Integer> countVowels(String content) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : content.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        return count;
    }

    public static HashMap<Character, Integer> countDigits(String content) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : content.toCharArray()) {
            if (Character.isDigit(c)) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        return count;
    }

    public static ArrayList<String> findTopNWords(String content, int n, boolean isTop) {
        HashMap<String, Integer> count = new HashMap<>();
        String[] words = content.split("[^a-zA-Z0-9]+");
        for (String word : words) {
            if (word.length() > 0) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> isTop ? b.getValue().compareTo(a.getValue()) : a.getValue().compareTo(b.getValue()));
        ArrayList<String> topNWords = new ArrayList<>();
        for (int i = 0; i < Math.min(n, list.size()); i++) {
            topNWords.add(list.get(i).getKey() + ":" + list.get(i).getValue());
        }
        return topNWords;
    }

    public static ArrayList<Character> findTopNChars(String content, int n, boolean isTop) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : content.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> isTop ? b.getValue().compareTo(a.getValue()) : a.getValue().compareTo(b.getValue()));
        ArrayList<Character> topNChars = new ArrayList<>();
        for (int i = 0; i < Math.min(n, list.size()); i++) {
            topNChars.add(list.get(i).getKey());
        }
        return topNChars;
    }
}


package AoC.AoC2023.Day1;
import AoC.ReadInput;

import java.util.Map;

public class Day1{

    static ReadInput in;

    public static void main(String[] args) {
        in = new ReadInput("day1.txt");

        String line;
        int sum_p1 = 0;
        int sum_p2 = 0;
        while((line = in.readLine()) != null) {
            sum_p1 += part1(line);
            sum_p2 += part2(line);
        }
        System.out.println(sum_p1);
        System.out.println(sum_p2);
    }

    static int part1(String line) {
        int first = 0;
        int last = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                first = Character.getNumericValue(c);
                break;
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                last = Character.getNumericValue(c);
                break;
            }
        }
        
        return first * 10 + last;
    }

    static int part2(String line) {
        Map <String, Integer> words = Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five",5, "six",6, "seven",7, "eight",8, "nine",9);

        String first_word = "";
        int first_index = line.length();
        String last_word = "";
        int last_index = -1;

        for (String word : words.keySet()) {
            int first = line.indexOf(word);
            int last = line.lastIndexOf(word);
            if (first != -1 && first < first_index) {
                first_index = first;
                first_word = word;
            }
            if (last != -1 && last > last_index) {
                last_index = last;
                last_word = word;
            }
        }

        if (!first_word.isEmpty())
            line = line.replace(first_word, words.get(first_word) + first_word);
        if (!last_word.isEmpty())
            line = line.replace(last_word, last_word + words.get(last_word));

        return part1(line);
    }


}

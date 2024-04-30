package AoC.AoC2023.Day2;

import AoC.ReadInput;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    static ReadInput in;

    public static void main(String[] args) {
        in = new ReadInput("day2.txt");

        String line;
        int id = 1;
        int sum_p1 = 0;
        int sum_p2 = 0;

        while((line = in.readLine()) != null) {
            if (part1(line)) {
                sum_p1 += id;
            }
            sum_p2 += part2(line);

            id ++;
        }

        System.out.println(sum_p1);
        System.out.println(sum_p2);
    }

    /**
     * Returns whether a game is valid
     * @param line line input
     * @return whether the game is valid
     */
    static boolean part1(String line) {
        String[] gameSets = line.split(":")[1].split(";");
        for (String gameSet : gameSets) {
            for (String value : gameSet.split(",")){
                String[] valuePair = value.strip().split(" ");
                if (valuePair[1].equals("red") && Integer.parseInt(valuePair[0]) > 12) {
                    return false;
                }
                if (valuePair[1].equals("green") && Integer.parseInt(valuePair[0]) > 13) {
                    return false;
                }
                if (valuePair[1].equals("blue") && Integer.parseInt(valuePair[0]) > 14) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the product of minimum number of cubes needed
     * @param line line input
     * @return product of minimum number of cubes needed
     */
    static int part2(String line) {
        int red = 0;
        int blue = 0;
        int green = 0;

        String[] gameSets = line.split(":")[1].split(";");
        for (String gameSet : gameSets) {
            for (String value : gameSet.split(",")){
                String[] valuePair = value.strip().split(" ");
                if (valuePair[1].equals("red")) {
                    red = Math.max(red, Integer.parseInt(valuePair[0]));
                }
                if (valuePair[1].equals("green")) {
                    green = Math.max(green, Integer.parseInt(valuePair[0]));
                }
                if (valuePair[1].equals("blue")) {
                    blue = Math.max(blue, Integer.parseInt(valuePair[0]));
                }
            }
        }
        return red * green * blue;
    }
}

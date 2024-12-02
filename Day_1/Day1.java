package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        int total = 0;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        try {
            File inputFile = new File("Day_1/Day1Input.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String[] numsString = scanner.nextLine().split("\\s+");
                leftList.add(Integer.parseInt(numsString[0]));
                rightList.add(Integer.parseInt(numsString[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        // Puzzle 1
        for (int i = 0; i < leftList.size(); i++) {
            int diff = Math.abs(leftList.get(i) - rightList.get(i));
            System.out.println("Number 1: " + leftList.get(i) + ", Number 2: " + rightList.get(i) + ", Difference: " + diff);
            total += diff;
        }
        System.out.println("Total: " + total);

        // Puzzle 2
        int simScore = 0;
        for (int leftNum: leftList) {
            int count = Collections.frequency(rightList, leftNum);
            System.out.println("Number: " + leftNum + ", Frequency: " + count);
            simScore += leftNum * count;
        }
        System.out.println(simScore);
    }
}

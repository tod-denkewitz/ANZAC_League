package ANZAC2013_Round3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Luke and Tod
 */
public class ProblemA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            String input = sc.nextLine();
            
            // separate names
            String name1 = input.split(" ")[0].toLowerCase();
            String name2 = input.split(" ")[1].toLowerCase();
            
            LinkedList<Character> uniqueLetters = new LinkedList<Character>();

            // find unique letters in name1
            for (int i = 0; i < name1.length(); i++) {
                if (!uniqueLetters.contains(name1.charAt(i)))
                    uniqueLetters.add(name1.charAt(i));
            }

            // find unique letters in name2
            for (int i = 0; i < name2.length(); i++) {
                if (!uniqueLetters.contains(name2.charAt(i)))
                    uniqueLetters.add(name2.charAt(i));
            }

            int matches = 0;
            
            // count unique matches
            for (Character c : uniqueLetters) {
                if (name1.contains(c.toString()) && name2.contains(c.toString()))
                    matches++;
            }

            long rating = (long) (((double) matches / (double) uniqueLetters.size()) * 100); // calcalate compatibility rating
            
            System.out.println((rating >= 40) ? "Get hitched" : "Part ways"); // print result
        }
    }
}
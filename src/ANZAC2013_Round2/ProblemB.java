package ANZAC2013_Round2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Tod
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine(); // initial input line

        while (input.compareTo(".") != 0) {

            String[] spl = input.split(", ");

            // remove trailing dot
            spl[spl.length - 1] = spl[spl.length - 1].substring(0, spl[spl.length - 1].length() - 1);

            char[] mask = new char[spl.length];
            LinkedList<String> words = new LinkedList<String>();
            LinkedList<Integer> numbers = new LinkedList<Integer>();

            for (int i = 0; i < spl.length; i++) {
                int num;
                String word;

                Scanner sc2 = new Scanner(spl[i]);
                // dirty try/catch block used as an if statement
                try {
                    num = sc2.nextInt();
                    numbers.add(num);
                    mask[i] = 'N'; // number
                } catch (java.lang.Exception e) { // parsing for int throws exception, so it must be a word
                    word = spl[i];
                    words.add(word);
                    mask[i] = 'S'; // string
                }
            }

            Collections.sort(numbers); // sort the numbers
            Collections.sort(words, new Comparator<String>() { // sort the words
                @Override
                public int compare(String arg0, String arg1) {
                    return arg0.compareToIgnoreCase(arg1); // ignore case
                }
            });

            for (int i = 0; i < mask.length; i++) {
                if (mask[i] == 'N')
                    System.out.printf("%d", numbers.removeFirst());
                else
                    System.out.printf("%s", words.removeFirst());
//                System.out.printf("%s", (mask[i] == 'N') ? Integer.toString(values.removeFirst()) : words.removeFirst());
                
                System.out.printf("%s", ((i + 1) == mask.length) ? ".\n" : ", ");
            }

            input = sc.nextLine(); // get new line of input
        }
    }
}

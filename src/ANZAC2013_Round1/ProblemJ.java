package ANZAC2013_Round1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Tod
 */
public class ProblemJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            LinkedList<TreeSet<String>> networks = new LinkedList<TreeSet<String>>();

            for (int n = 0; n < N; n++) {
                String input = sc.nextLine();
                String name1 = input.split(" ")[0];
                String name2 = input.split(" ")[1];

                TreeSet<String> joinedNetwork = new TreeSet<String>();

                for (int i = 0; i < networks.size(); i++) {
                    TreeSet<String> net = networks.get(i);

                    if (net.contains(name1) || net.contains(name2)) {
                        joinedNetwork.addAll(net);
                        networks.remove(net);
                        i--;
                    }
                }

                if (!joinedNetwork.contains(name1)) {
                    joinedNetwork.add(name1);
                }
                if (!joinedNetwork.contains(name2)) {
                    joinedNetwork.add(name2);
                }

                networks.add(joinedNetwork);
                System.out.printf("%d\n", joinedNetwork.size());
            }
        }
    }
}

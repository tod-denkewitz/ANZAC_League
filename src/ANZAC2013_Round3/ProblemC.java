package ANZAC2013_Round3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Tod
 */
public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine();

            char[][] grid = new char[X][Y];

            for (int x = 0; x < X; x++) {
                String input = sc.nextLine();
                for (int y = 0; y < Y; y++) {
                    grid[x][y] = input.charAt(y);
                }
            }

            LinkedList<Node> gems = new LinkedList<Node>();

            for (int x = 0; x < X; x++) {
                for (int y = 0; y < Y; y++) {
                    switch (grid[x][y]) {
                        case 'R':
                            Node ruby = new Node();
                            ruby.value = 5;
                            ruby.x = x;
                            ruby.y = y;
                            gems.add(ruby);
                            break;
                        case 'D':
                            Node diamond = new Node();
                            diamond.value = 10;
                            diamond.x = x;
                            diamond.y = y;
                            gems.add(diamond);
                            break;
                        case 'E':
                            Node emerald = new Node();
                            emerald.value = 4;
                            emerald.x = x;
                            emerald.y = y;
                            gems.add(emerald);
                            break;
                        case 'S':
                            Node sapphire = new Node();
                            sapphire.value = 6;
                            sapphire.x = x;
                            sapphire.y = y;
                            gems.add(sapphire);
                            break;
                        case 'X':
                            break;
                    }
                }
            }

            for (Node gem : gems) {
                int x = gem.x, y = gem.y;

                if (y > 0) { // up
                    if (grid[x][y - 1] != 'X') {
                        for (Node a : gems) {
                            if (a.x == x && a.y == (y - 1)) {
                                gem.adj.add(a);
                                break;
                            }
                        }
                    }
                }

                if (y < Y - 1) { // down
                    if (grid[x][y + 1] != 'X') {
                        for (Node a : gems) {
                            if (a.x == x && a.y == (y + 1)) {
                                gem.adj.add(a);
                                break;
                            }
                        }
                    }
                }

                if (x > 0) { // left
                    if (grid[x - 1][y] != 'X') {
                        for (Node a : gems) {
                            if (a.x == (x - 1) && a.y == y) {
                                gem.adj.add(a);
                                break;
                            }
                        }
                    }
                }

                if (x < X - 1) { // right
                    if (grid[x + 1][y] != 'X') {
                        for (Node a : gems) {
                            if (a.x == (x + 1) && a.y == y) {
                                gem.adj.add(a);
                                break;
                            }
                        }
                    }
                }
            }

            int bestVal = 0;

            for (Node gem : gems) {
                if (!gem.visited) {
                    gem.best = findBest(gem);
                    if (gem.best > bestVal) {
                        bestVal = gem.best;
                    }
                }
            }

            System.out.println(bestVal);
        }
    }

    public static int findBest(Node gem) {
        int best = gem.value;
        gem.visited = true;

        for (Node a : gem.adj) {
            if (!a.visited) {
                best += findBest(a);
            }
        }

        return best;
    }

    public static class Node {

        public LinkedList<Node> adj;
        public int value, x, y, best;
        public Boolean visited;

        public Node() {
            adj = new LinkedList<Node>();
            best = 0;
            visited = false;
        }
    }
}
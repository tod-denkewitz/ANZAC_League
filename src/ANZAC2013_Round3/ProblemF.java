package ANZAC2013_Round3;

import java.util.Scanner;

/**
 *
 * @author Luke
 */
public class ProblemF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfSquares = sc.nextInt();

        while (numOfSquares != 0) {
            int finalWidth = 1, finalHeight = 1;

            Node[] nodeArray = new Node[numOfSquares];
            for (int i = 0; i < nodeArray.length; i++) {
                nodeArray[i] = new Node();
            }
            int nextNodeNumber = 0;
            for (int i = 0; i < (numOfSquares - 1); i++) {
                int currentNodeLocation = sc.nextInt();
                int nextNodePosition = sc.nextInt();
                nextNodeNumber++;

                Node currentNode = nodeArray[currentNodeLocation];
                switch (nextNodePosition) {
                    case 0: //left
                        currentNode.left = nodeArray[nextNodeNumber];
                        nodeArray[nextNodeNumber].right = currentNode;
                        nodeArray[nextNodeNumber].xPos = (currentNode.xPos - 1);
                        nodeArray[nextNodeNumber].yPos = currentNode.yPos;
                        break;
                    case 1: //below
                        currentNode.down = nodeArray[nextNodeNumber];
                        nodeArray[nextNodeNumber].up = currentNode;
                        nodeArray[nextNodeNumber].yPos = (currentNode.yPos - 1);
                        nodeArray[nextNodeNumber].xPos = currentNode.xPos;
                        break;
                    case 2: //right
                        currentNode.right = nodeArray[nextNodeNumber];
                        nodeArray[nextNodeNumber].left = currentNode;
                        nodeArray[nextNodeNumber].xPos = (currentNode.xPos + 1);
                        nodeArray[nextNodeNumber].yPos = currentNode.yPos;
                        break;
                    case 3: //up
                        currentNode.up = nodeArray[nextNodeNumber];
                        nodeArray[nextNodeNumber].down = currentNode;
                        nodeArray[nextNodeNumber].yPos = (currentNode.yPos + 1);
                        nodeArray[nextNodeNumber].xPos = currentNode.xPos;
                        break;
                }


            }
            int furthestRight = 0, furthestLeft = 0, furthestUp = 0, furthestDown = 0;
            for (int i = 0; i < nodeArray.length; i++) {
                Node currentNode = nodeArray[i];
                if (currentNode.xPos > furthestRight) {
                    furthestRight = currentNode.xPos;
                }
                if (currentNode.xPos < furthestLeft) {
                    furthestLeft = currentNode.xPos;
                }
                if (currentNode.yPos > furthestUp) {
                    furthestUp = currentNode.yPos;
                }
                if (currentNode.yPos < furthestDown) {
                    furthestDown = currentNode.yPos;
                }
            }

            finalWidth = (Math.abs(furthestLeft) + furthestRight) + 1;
            finalHeight = (Math.abs(furthestDown) + furthestUp) + 1;

            System.out.printf("%d %d\n", finalWidth, finalHeight);
            numOfSquares = sc.nextInt();
        }
    }

    public static int searchNodeLinks(Node node, int direction) {
        int distance = 0;

        switch (direction) {
            case 0: //left
                if (node.left == null) {
                    distance += 1;
                } else {
                    distance = searchNodeLinks(node.left, 0);
                    distance += 1;
                }
                break;
            case 1: //below
                if (node.down == null) {
                    distance += 1;
                } else {
                    distance = searchNodeLinks(node.down, 1);
                    distance += 1;
                }
                break;
            case 2: //right
                if (node.right == null) {
                    distance += 1;
                } else {
                    distance = searchNodeLinks(node.right, 2);
                    distance += 1;
                }
                break;
            case 3: //up
                if (node.up == null) {
                    distance += 1;
                } else {
                    distance = searchNodeLinks(node.up, 3);
                    distance += 1;
                }
                break;
        }

        return distance;
    }
    
    public static class Node {

        Node up, left, right, down;
        int xPos, yPos;

        public Node() {
            up = null;
            left = null;
            right = null;
            down = null;
            xPos = 0;
            yPos = 0;
        }
    }
}

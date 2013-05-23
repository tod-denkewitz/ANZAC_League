package ANZAC2013_Round3;

import java.util.Scanner;

/**
 *
 * @author Luke
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numBuildings = sc.nextInt();

            int biggestWidth = 0, biggestHeight = 0;
            Integer[][] buildingLand = new Integer[50][50];
            
            for (int n = 0; n < numBuildings; n++) {
                int xOrigin, buildingWidth, buildingHeight, buildingDepth;
                xOrigin = sc.nextInt();
                buildingWidth = sc.nextInt();
                buildingHeight = sc.nextInt();
                buildingDepth = sc.nextInt();

                if ((xOrigin + buildingWidth) > biggestWidth) {
                    biggestWidth = (xOrigin + buildingWidth);
                }

                if ((xOrigin + buildingHeight) > biggestHeight) {
                    biggestHeight = (xOrigin + buildingHeight);
                }

                for (int i = xOrigin; i < (xOrigin + buildingWidth); i++) {
                    for (int j = 0; j < buildingHeight; j++) {
                        if (buildingLand[i][j] == null) {
                            buildingLand[i][j] = 1;
                        } else {
                            buildingLand[i][j]++;
                        }
                    }
                }
            }
            
            long windowsBlocked = 0L;
            
            for (int i = 0; i < biggestWidth; i++) {
                for (int j = 0; j < biggestHeight; j++) {
                    if (buildingLand[i][j] != null) {
                        windowsBlocked += (buildingLand[i][j] - 1);
                    }
                }
            }

            System.out.println(windowsBlocked);
        }
    }
}

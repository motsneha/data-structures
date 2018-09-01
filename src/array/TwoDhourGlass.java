package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoDhourGlass {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int[][] sums = new int[4][4];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sums[i][j] = sumTheHourGlass(arr, i, j);
                if (sums[i][j] > max) {
                    max = sums[i][j];
                }
            }

        }

        System.out.println(max);
    }


    public static int sumTheHourGlass(int[][] arr, int p, int q) {
        int sum = 0;

        for (int i = p; i < p + 3; i++) {
            for (int j = q; j < q + 3; j++) {
                if (i == p + 1 && (j == q || j == q + 2)) {
                    continue;
                }
                sum = sum + arr[i][j];

            }
        }

        return sum;
    }
}

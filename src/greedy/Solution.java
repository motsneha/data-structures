package greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int cost = 0;
        int n = c.length;
        if (n <= k) {
            int min = Math.min(n, k);
            for (int i = 0; i < min; i++) {
                cost = cost + c[i];
            }
        } else {
            Arrays.sort(c);
            int j = n - 1;

            int rounds = n / k;
            int remainingFlowers = n % k;
            System.out.println("No of rounds " + rounds);
            System.out.println("No of Remaining flowers " + remainingFlowers);


            for (int i = 1; i <= rounds; i++) {
                System.out.println("Starting " + i + " round");
                cost = cost + (i * c[j]);
                System.out.println("Cost after " + i + " round is " + cost);
                j--;
            }

            System.out.println("Remaining flowers will be pr");
            if (remainingFlowers > 0 && j >= 0) {
                for (int p = 1; p < remainingFlowers; p++) {
                    cost = cost + p * c[j];
                    j--;
                }
            }

        }

        return cost;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);
        scanner.close();
    }
}

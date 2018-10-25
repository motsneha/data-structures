package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int n = q.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int j = i + 1;
            if (j == q[i]) {
                continue;
            } else {

                if (j > q[i]) {

                } else if (j < q[i]) {

                }
                int temp = q[i];
                q[i] = j;
                q[temp - 1] = temp;
                count = temp - j;
                total = total + count;
                System.out.println();
                System.out.println("Count for index  " + i + " is " + count);
            }

    }
        System.out.println(total);
}


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] array = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                minimumBribes(array);
            }

        } catch (Exception e) {

        } finally {
            try {
                br.close();
            } catch (IOException e) {

            }
        }
    }
}

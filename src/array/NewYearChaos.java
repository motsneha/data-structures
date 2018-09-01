package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int n = q.length;
        int total = 0;
        for (int i = n - 1; i >= 0; i = i - 1) {

            if (q[i] == i + 1) {
                continue;
            } else {
                int j = i - 1;
                while (j > 0) {
                    int count = 0;
                    if (q[j] == i + 1) {
                        int temp = q[j];
                        q[j] = q[i];
                        q[i] = temp;
                        count++;
                        total++;
                    }
                    if(count > 2){
                        System.out.println("Too chaotic");
                        return;
                    }
                    j--;

                }
            }
            System.out.println(total);
        }
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

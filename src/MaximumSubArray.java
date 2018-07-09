import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubArray {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nt = Integer.parseInt(st.nextToken());

            for (int t = 0; t < nt; t++) {

                int n = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());

                int[] arr = new int[n];
                int maxGlobal = 0;
                int maxCurrent = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken(" "));
                    if (i == 0) {
                        maxCurrent = arr[i];
                        maxGlobal = arr[i];
                    }
                    maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
                    if (maxCurrent > maxGlobal) {
                        maxGlobal = maxCurrent;
                    }


                }
                System.out.println(maxGlobal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
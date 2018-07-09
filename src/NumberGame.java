import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberGame {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            int nt = Integer.parseInt(br.readLine());

            for (int t = 0; t < nt; t++) {

                int[] aliceNumbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] bobNumbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int aliceScore = 0;
                int bobScore = 0;
                for (int i = 0; i < aliceNumbers.length; i++) {
                    if (aliceNumbers[i] > bobNumbers[i]) {
                        aliceScore++;
                    } else if (aliceNumbers[i] < bobNumbers[i]) {
                        bobScore++;
                    } else {

                    }
                }
                System.out.println(aliceScore + " " + bobScore);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class MaximumAvgSubArray {

    static class TestClass {
        public static void main(String[] args) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(br.readLine());

                int[] array = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                Arrays.sort(array);
                int nk = Integer.parseInt(br.readLine());
                for (int t = 0; t < nk; t++) {
                    int avgK = Integer.parseInt(br.readLine());
//                    System.out.println("starting for avgk " + avgK);
                    if (avgK <= 1) {
                        System.out.println(0);
                    } else {
                        int count = 0;

                        for (int i = 0; i < array.length; i++) {
                            int[] range = Arrays.copyOfRange(array, 0, i);
                            double avg = avg(range);
//                            System.out.println("for sub array  0 - " + i + " avg is " + avg + " avgK is " + avgK);
                            if ((int)avg < avgK) {
                                count = range.length;
                            } else if (avg >= avgK) {
                                break;
                            }

                        }
                        System.out.println(count);
                    }
                }

            } catch (Exception e) {
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        private static double avg(int[] i) {
            OptionalDouble average = Arrays.stream(i).average();
            if (average.isPresent()) {
                return average.getAsDouble();
            } else {
                return 0;
            }
        }
    }
}

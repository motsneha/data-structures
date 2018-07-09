import java.util.Scanner;

public class CounterGame {
    // Complete the counterGame function below.
    static String counterGame(long n) {

        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println( counterGame(n));


        }



        scanner.close();
    }
}

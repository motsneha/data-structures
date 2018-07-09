import java.util.Scanner;

/**
 * ugly number problem https://www.geeksforgeeks.org/?p=753
 */
public class UglyNumberDynamicProgramming {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for 2,3,5 set");
        int number = sc.nextInt();
        sc.close();
        System.out.println(getUglyNumber(number));
    }

    public static int getUglyNumber(int n) {

        int ugly[] = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        int nextMultiple2 = ugly[i2] * 2;
        int nextMultiple3 = ugly[i3] * 3;
        int nextMultiple5 = ugly[i5] * 5;

        int nextUglyNumber = 0;
        for (int k = 1; k < n; k++) {
            nextUglyNumber = Math.min(nextMultiple5, Math.min(
                    nextMultiple2,
                    nextMultiple3)
            );

            ugly[k] = nextUglyNumber;

            if (nextUglyNumber == nextMultiple2){
                i2++;
                nextMultiple2 = ugly[i2] * 2;
            }

            if (nextUglyNumber == nextMultiple3){
                i3++;
                nextMultiple3 = ugly[i3] * 3;
            }


            if (nextUglyNumber == nextMultiple5){
                i5++;
                nextMultiple5 = ugly[i5] * 5;
            }
            System.out.println( "i2 : " + i2 +   " i3 : " + i3 + " i5 : " + i5 + " uglyNumber : " + ugly[k]);
        }
        return nextUglyNumber;
    }
}

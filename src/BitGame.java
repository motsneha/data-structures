import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitGame {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {

            int nt = Integer.parseInt(br.readLine());


            for (int t = 0; t < nt; t++) {
                int n = Integer.parseInt(br.readLine());
                char[] bitsChar = Integer.toBinaryString(n).toCharArray();
                int[] bits = charToIntArray(bitsChar);
                int m = bitsChar.length;
                for (int k = 0; k < m; k++) {

                    int temp = bits[k];
                    toggleKthBit(bits, k);

                    if (k != 0 && temp == bits[k - 1]) {
                        toggleKthBit(bits, k - 1);

                    }
                    if (k != m - 1 && temp == bits[k + 1]) {
                        toggleKthBit(bits, k + 1);

                    }

                }
                String lastMove = m % 2 == 0 ? "Y" : "X";

                int finalNumber = toDecimal(bits);
                if (n == finalNumber || n + 1 == finalNumber || n - 1 == finalNumber) {
                    System.out.println(lastMove);
                } else {
                    System.out.println(lastMove.equals("X") ? "Y" : "X");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
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


    public static int[] charToIntArray(char[] chars) {
        int[] intArr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            intArr[i] = Integer.valueOf(String.valueOf(chars[i]));
        }
        return intArr;
    }

    static int toDecimal(int[] bits) {
        int dec = 0;
        int m = bits.length - 1;
        for (int p = 0 ; p <= m ; p++) {
            if(bits[p]!=0) {
                int pow = (int) Math.pow(2, m - p);
                dec = dec + pow;
            }
        }
        return dec;
    }

    static void toggleKthBit(int[] n, int k) {
        n[k] = n[k] ^ 1;

    }

}




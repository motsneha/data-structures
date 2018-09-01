import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;


public class HackerEarth {

    /**
     * Alex and his String
     * Alex has a string S of length N consisting of lowercase alphabets. He wants to find lexicographically smallest string X of length N that can be formed using the following operation.
     * <p>
     * In one operation, he can select any one character among the at most first K characters of string S, remove it from string S and append it to string X. He can apply this operation as many times as he wants.
     * <p>
     * Help Alex find the string X.
     * <p>
     * Input format
     * <p>
     * The first line consists of a string of length N
     * The second line consists of an integer K.
     * Output format
     * <p>
     * Print the lexicographically minimum string that can be formed using the above operation.
     * Sample Input
     * hackerearth
     * 3
     * Sample Output
     * aceheakrhrt
     * Explanation
     * First you can select 'a' from "hackerearth". Now the string X becomes "a" and string S becomes "hckerearth".
     * <p>
     * Now after applying the operation again, the string X becomes "ac" and the string S becomes "hkerearth".
     * <p>
     * Similarly after applying the operation n times, the string X becomes "aceheakrhrt".
     * <p>
     * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
     */
    static class TestClass {
        public static void main(String args[]) throws Exception {

            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                String name = new String(br.readLine());                // Reading input from STDIN
                int k = Integer.parseInt(br.readLine());
                char[] nameCharArray = name.toCharArray();
                int length = nameCharArray.length;
                char[] result = new char[length];

                int i = 0;
                if (k > length) {
                    Arrays.sort(nameCharArray);
                    System.out.println(new String(nameCharArray));
                }
                else if (length == 0 || k == 0 || length == 1) {
                    System.out.println(name);
                }
                else {
                    while (nameCharArray.length > 0) {
                        int j = nameCharArray.length < 3 ? nameCharArray.length : 3;
                        int c = findLexiSmallestElement(nameCharArray, 0, j);
                        result[i] = nameCharArray[c];
                        nameCharArray = removeKthChar(nameCharArray, c);
                        i++;
//                        System.out.println("pass " + i + " result is " + new String(result) + " original string is " + new String(nameCharArray));
                    }
                    System.out.println(new String(result));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != br)
                    br.close();
            }
        }

        public static char[] removeKthChar(char[] ch, int k) {
            char[] result = new char[ch.length - 1];
            int p = 0;
            int i = 0;
            while (p < ch.length) {
                if (p == k) {

                } else {
                    result[i] = ch[p];
                    i++;
                }
                p++;
            }

            return result;
        }

        private static int findLexiSmallestElement(char[] nameCharArray, int i, int j) {
            int smallest = nameCharArray[i];
            int smallestIndex = i;
            if (i == j) {
                return i;
            } else if (j > nameCharArray.length) {
                j = nameCharArray.length - 1;
            } else {
                for (int k = i + 1; k < j; k++) {
                    smallest = Math.min(smallest, (int) nameCharArray[k]);
                    if (nameCharArray[k] == smallest) {
                        smallestIndex = k;
                    }
                }
            }

            return smallestIndex;
        }
    }
}

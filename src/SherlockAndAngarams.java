import java.util.*;

public class SherlockAndAngarams {

    static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "[" + this.i + "," + this.j + "]";
        }
    }

    public static void main(String[] args) {
        String test = "abba";
        int anagrams = 0;
        Map<Integer, Integer> charMap = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            System.out.println("hashing started for " + i);

            for (int j = i + 1; j <= test.length(); j++) {

                String key = test.substring(i, j);

                System.out.println("Key " + key);


                Integer countOfSubString = charMap.getOrDefault(h(key), 0);
                charMap.put(h(key), ++countOfSubString);

//                System.out.println("Key " + key + " Key  :" + h(key) + " Value " + charMap.get(h(key)));

//                if (j != test.length()) {
//
//                }

//                System.out.println("Key " + key + " Key  :" + h(key) + " Value " + charMap.get(h(key)));
            }
            System.out.println("===");
//            for (int j = i + 1; j < test.length(); j++) {
//                String str = new String(new char[]{test.charAt(j)});
//                Integer countOfCurrentChar = charMap.getOrDefault(h(str), 0);
//                charMap.put(h(str), ++countOfCurrentChar);
//                System.out.println("--Key " + str + " Key  :" + h(str) + " Value " + charMap.get(h(str)));
//            }

        }

        for (Map.Entry<Integer, Integer> entry : charMap.entrySet()) {
            System.out.println("processing entry " + entry);
            Integer value = entry.getValue();
            if (value >= 2) {
                anagrams = anagrams + value;
            }
        }

        System.out.println(anagrams);
    }

    static int h(String x) {
//        char ch[];
//        ch = x.toCharArray();
//        int xlength = x.length();
//
//        int i, sum;
//        for (sum = 0, i = 0; i < xlength; i++)
//            sum += ch[i];
//        return sum % 256;
        return Objects.hashCode(x);
    }

    static int hash(String input) {

        int hash = input.length();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            hash = hash + 31 * c;
        }
        return hash;
    }
}

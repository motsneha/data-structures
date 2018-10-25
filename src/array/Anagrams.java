package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
    private static final int N = 26;

    private static boolean isAnagram(String a, String b) {
        int[] countA = new int[N];
        int[] countB = new int[N];

        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }


        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }





        for (int i = 0; i < N; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;
    }

    private static int getPairsCount(String text) {
        int count = 0;
        int length = text.length();

        List<String> subsets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                System.out.println(text.substring(i, i + j));
                subsets.add(text.substring(i, i + j));
            }
            System.out.println("===");
        }


        for (int i = 0; i < subsets.size(); i++) {
            for (int j = i + 1; j < subsets.size(); j++) {
                String s1 = subsets.get(i);
                String s2 = subsets.get(j);
                if (isAnagram(s1, s2)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(getPairsCount(s.next()));
        }
    }

}

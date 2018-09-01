import java.util.HashMap;
import java.util.Map;

public class CommonSubString {

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";

        int lengthS1 = s1.length();
        int lengthS2 = s2.length();

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < lengthS1; i++) {
            int count = freq.getOrDefault(s1.charAt(i), 0);
            freq.put(s1.charAt(i), ++count);
        }
        for (int i = 0; i < lengthS2; i++) {
            int count = freq.getOrDefault(s2.charAt(i), 0);
            if(count > 0){
                System.out.println("Yes");
            }
        }

        System.out.println("No");


    }
}

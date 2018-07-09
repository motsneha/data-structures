import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MorseMap {

    public static Map<Character, String> morseMap = new HashMap<>();

    static {

        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");

    }

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> morseWords = new HashSet<>();
        for (String word : words) {
            StringBuffer morseCode = new StringBuffer();
            for (Character c : word.toCharArray()) {
                morseCode.append(morseMap.get(c));
            }
            morseWords.add(morseCode.toString());
        }
        return morseWords.size();
    }


}

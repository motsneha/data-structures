public class LongestConsecutiveChars {

    public static void main(String[] args) {
        String sequence = "AABCDDDBBBEA";

        int maxCount = 0;
        Character maxChar = null;
        Character prevChar = null;
        int count = 0;
        for (Character character : sequence.toCharArray()) {
            if (prevChar == character) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxChar = character;
                maxCount = count;
            }
            prevChar = character;

        }
        System.out.println("Max Char : " + maxChar + " Max count : " + maxCount);
    }
}

public class JewelsStonesLeetCode {

    public static void main(String[] args) {
        String S = "aA";
        String J = "aAAAbbbb";


    }
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] stones = S.toCharArray();
        for(Character j : J.toCharArray()){
            for(char c : stones){
                if(j == c){
                    count++;
                }
            }
        }
       return count;
    }
}

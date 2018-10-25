public class Abbreviation {


    public static void main(String[] args) {
        String a = "dabcd";
        String b = "ABC";
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i) || a.charAt(1) + 32 == b.charAt(i)) {
                count++;
            }
        }
        if(count == b.length()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

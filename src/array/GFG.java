package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class GFG {
    public static void main(String[] args) {
        //code
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nt = Integer.parseInt(st.nextToken());

            for (int t = 0; t < nt; t++) {
                String actual = br.readLine();
                String[] words = actual.split("\\.");
                int l = words.length;
                for (int j = l - 1; j >= 0; j--) {
                    if (j == 0) {
                        System.out.println(words[j]);
                    }else {
                        System.out.print(words[j] + ".");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {

        } finally {
            if(null!= br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
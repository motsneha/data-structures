import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashPyramid {

    public static void main(String[] args)  {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try{


            StringTokenizer st = new StringTokenizer(br.readLine());

            int nt = Integer.parseInt(st.nextToken());


            for (int t = 0; t < nt; t++) {


                int n = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());


                int[] arr = new int[n];
                int[] hash = new int[10];
                int max = hash[0];


//                int[] array = Arrays.stream(br.readLine().split(" "))
//                        .mapToInt(Integer::parseInt).toArray();
//                int[] hashes = Arrays.stream(array).map(value -> value % 10).toArray();
//                Arrays.stream(hashes)
                IntStream integerStream = Arrays.stream(hash);
                OptionalInt optionalInt = integerStream.max();
                max = optionalInt.getAsInt();

                for (int q = max; q > 0; q--) {
                    for (int p = 0; p < 10; p++) {
                        if (hash[p] >= q) {
                            System.out.print("0");
                        } else {
                            System.out.print(" ");
                        }
                    }

                    System.out.println("");
                }
                for (int r = 0; r < 10; r++) {
                    System.out.print(r);
                }
                System.out.println("");
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

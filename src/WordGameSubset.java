import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordGameSubset {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int nt = Integer.parseInt(st.nextToken());

            for (int i = 0; i < nt; i++) {

                Stream<String> knightWords = Stream.of(br.readLine().split(" "));
                Stream<String> jackWords = Stream.of(br.readLine().split(" "));

                Map<String, Long> jackCount =
                        jackWords.collect(groupingBy(identity(), counting()));

                Map<String, Long> knightCount =
                        knightWords.collect(groupingBy(identity(), counting()));

//                for(String k : jackCount.keySet()){
//                    System.out.println(k);
//                }

//                for(String k : knightCount.keySet()){
//                    System.out.println(k);
//                }
                Set<String> originaljackSet = new HashSet<String >(jackCount.keySet());
                jackCount.keySet().removeAll(knightCount.keySet());
                knightCount.keySet().removeAll(originaljackSet);


                if (jackCount.keySet().size() > 0 && knightCount.keySet().size() == 0) {
                    System.out.println("Jack Wins");
                } else if (knightCount.keySet().size() > 0) {
                    System.out.println("Knight Wins");
                } else {
                    System.out.println("Drawn");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

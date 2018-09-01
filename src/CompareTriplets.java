import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Iterator<Integer> aliceIterator = a.iterator();
        Iterator<Integer> bobIterator = b.iterator();
        int alicScore = 0;
        int bobScore = 0;
        while (aliceIterator.hasNext() && bobIterator.hasNext()) {
            Integer currentAScore = aliceIterator.next();
            Integer currentBobScore = bobIterator.next();
            if (currentAScore > currentBobScore) {
                alicScore++;
            } else if (currentAScore < currentBobScore) {
                bobScore++;
            }
        }
        return Stream.of(alicScore, bobScore).collect(toList());
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        int numLastIndex = num.length - 1;
        for (int i = 0; i < numLastIndex - 1; i++) {

            if (i == 0 || isCurrentDifferentFromPrevious(num, i)) {

                int lo = i + 1;
                int hi = numLastIndex;
                int sum = 0 - num[i];  // a + b = 0 - c

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        // found
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

                        while (lo < hi && num[lo] == num[lo + 1]) lo++; // dups on low index, move L index++

                        while (lo < hi && num[hi] == num[hi - 1]) hi--; // dups on high index, move H index--

                        // move indices to new positions with different values
                        lo++;

                        hi--;

                    } else if (num[lo] + num[hi] < sum) {
                        lo++;  // sum too small
                    } else {
                        hi--; // sum too large
                    }
                }
            }
        }
        return res;
    }

    private boolean isCurrentDifferentFromPrevious(int[] num, int i) {
        return i > 0 && num[i] != num[i - 1];
    }
}

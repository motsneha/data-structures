import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Pattern132 {

    public boolean find132pattern(int[] nums) {

        int firstIndex = 0;
        int middleNumber = 0;
        int lastNumber = 0;
        int lastIndex = -1;
        int middleIndex = -1;
        int firstNumber = nums[0];
        for (int j = 0; j < nums.length; j++) {
            firstNumber = nums[j];
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] > firstNumber) {
                    middleNumber = Math.max(nums[i], middleNumber);
                    middleIndex = i;
                }
                if (middleIndex != -1 && nums[i] < middleNumber) {
                    lastNumber = nums[i];
                }
            }

        }
        if (middleNumber > firstNumber && lastNumber < middleNumber) {
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
//        int[] nums = {1, 0, 1, -4, -3};
        int[] nums = {3, 5, 0, 3, 4};
        Pattern132 pattern132 = new Pattern132();
        System.out.println(pattern132.find132patternStack(nums));

    }
    public boolean find132patternStack(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }



    public boolean find132patternIntervals(int[] nums) {
        List<int[]> intervals = new ArrayList<>();
        int i = 1, s = 0;
        while (i < nums.length) {
            if (nums[i] <= nums[i - 1]) {
                if (s < i - 1)
                    intervals.add(new int[] {nums[s], nums[i - 1]});
                s = i;
            }
            for (int[] a: intervals)
                if (nums[i] > a[0] && nums[i] < a[1])
                    return true;
            i++;
        }
        return false;
    }

}


import java.util.Arrays;

public class ArrayPairSum {

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum = sum + nums[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        int nums[] = {1, 4, 2, 3, 7, 9, 10, 5};

        Arrays.sort(nums);

        System.out.println(arrayPairSum(nums));

    }
}

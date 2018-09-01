public class MinimumSwaps {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 2, 4, 5, 6};
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int ci = i + 1;
            int x = arr[i];
            if (x == ci) {
                continue;
            } else {

                int index = Math.min(arr.length, x);
                System.out.println("best index for " + x + " is " + index);
                int temp = arr[i];
                arr[index - 1] = arr[i];


            }
        }

        System.out.println(swaps);
    }
}

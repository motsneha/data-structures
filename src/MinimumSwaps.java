public class MinimumSwaps {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 3, 2, 4, 5, 6};
        int swaps = 0;
      /*  for (int i = 0; i < arr.length; i++) {
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
*/
        swaps = minimumSwaps(arr);
        System.out.println(swaps);
    }

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] != i + 1) {
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
                swaps++;
            }
        }
        return swaps;
    }
}

package array;

public class MaxArraySumNonAdjacent {


    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 40, 50, 35};
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
        int n = arr.length;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        System.out.println((incl > excl) ? incl : excl);
    }
}

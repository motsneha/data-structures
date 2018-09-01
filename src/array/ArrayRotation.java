package array;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        leftRotate(arr, arr.length, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        int[] result = leftRotate(arr, 3);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }


    static void leftRotate(int arr[], int n, int d) {
        int sets = gcd(n, d);
        int i, j, k, temp;
        for (i = 0; i < sets; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) k = k - n;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;

        }
    }

    static int[] leftRotate(int[] arr, int d) {
        int n = arr.length;
        int[] result = new int[n];
        int nofOfRotation = d;
        for (int i = 0; i < n; i++) {
            int newIndex = (i + d) % n;
            result[i] = arr[newIndex];
        }
        return result;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

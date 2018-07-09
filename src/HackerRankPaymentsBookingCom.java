public class HackerRankPaymentsBookingCom {
    public static void main(String[] args) {
//        System.out.println(triangle(100, 90, 200));

        int[] array = {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
        int[] delta_encode = delta_encode(array);
        int[][] matrix = {{1481122000, 1481122020}, {1481122000, 1481122040}, {1481122030, 1481122035}};

        howManyAgentsToAdd(0, matrix);


    }

    /*
     * Complete the howManyAgentsToAdd function below.
     */
    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        /*
         * Write your code here.
         */
        int count = 1;
        int[] startTimes = new int[callsTimes.length];
        int[] endtimes = new int[callsTimes.length];
        for (int row = 0; row < callsTimes.length; row++) {
            startTimes[row] = callsTimes[row][0];
            System.out.println(startTimes[row]);
            endtimes[row] = callsTimes[row][1];
            System.out.println(endtimes[row]);
        }

        for (int i = 0; i < callsTimes.length; i++) {
            for (int j = 1; j < callsTimes.length; j++) {
                if (startTimes[i] < startTimes[j] && startTimes[j] > endtimes[i]) {
                    count++;
                }
            }
        }
        if (noOfCurrentAgents > count) {
            return noOfCurrentAgents;
        } else {
            return count - noOfCurrentAgents;
        }
    }

    /*
     * Complete the delta_encode function below.
     */
    static int[] delta_encode(int[] array) {
        /*
         * Write your code here.
         */

        int[] result = new int[array.length];
        int[] indices = new int[array.length];
        int count = 0;
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                result[j] = array[i];
                j++;
            } else {
                int x = (array[i] - array[i - 1]);
                if (x > 127 || x < -127) {
                    indices[i] = -128;
                    count++;
                }
                result[i] = x;
                j++;
            }
        }
        int[] finalreult = new int[count + array.length];
        int k = 0;
        int i = 0;
        while (k < count + array.length && i < array.length) {
            if (indices[i] == -128) {
                finalreult[k] = -128;
                finalreult[k + 1] = result[i];
                k = k + 2;
            } else {
                finalreult[k] = result[i];
                k++;
            }
            i++;

        }
        return finalreult;
    }


    static int triangle(int a, int b, int c) {
        /*
         * Write your code here.
         */
        if (a <= 0 || b <= 0 || c <= 0) {
            return 0;
        } else if (a == b && b == c) {
            return 1;
        } else {
            if (a + b > c || a + c > b || b + c > a) {
                return 2;
            }
        }
        return 0;
    }
}

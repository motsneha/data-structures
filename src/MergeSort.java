public class MergeSort {

    public static void  main(String args[]){
        int[] array = {5,7,1,3,19,2,10,20};
        mergesort(array, new int[array.length], 0, array.length -1);
    }

    public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd) /2;
        mergesort(array, temp, leftStart, middle );
        mergesort(array, temp, leftStart, middle );
        mergeHalves(array, temp, leftStart, rightEnd);

    }
    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){

    }
}

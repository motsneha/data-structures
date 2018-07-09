import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum2 {

    public List<List<Integer>> getThreeSums(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        int posIndex = num.length - 1;
        int k = posIndex;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                posIndex = i + 1;
            }
        }

        for (int j = 1; j < num.length; j++) {
            while(k < num.length){
                if(num[j] != num[j-1]){
                    if(num[j] + posIndex + num[k] == 0){
                        res.add(Arrays.asList(num[j] , num[posIndex] , num[k]));
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//            threrSums()
    }
}


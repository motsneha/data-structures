import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            Map<Integer, List<Integer>> tree = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            int i;
            for (i = 0; i < n - 1; i++) {
                int[] array = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int u = array[0];
                int v = array[1];
                if (tree.get(u) == null) {
                    List<Integer> l = new ArrayList<>();
                    l.add(v);
                } else {
                    tree.get(u).add(v);
                }
                if (tree.get(v) == null) {
                    List<Integer> l = new ArrayList<>();
                    l.add(u);
                } else {
                    tree.get(v).add(u);
                }
            }
            List<Integer> used = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for (i = 0; i <= n; i++) {
                used.set(i, 0);
                res.set(i, 0);
            }
            getRes(0, 0, tree, used, res, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getRes(Integer depth, Integer dist, Map<Integer, List<Integer>> tree, List<Integer> used,
                              List<Integer> res, int i) {
        int maxDepth = 0, secMaxDepth = 0, maxDist = 0;
        if (tree.get(i) == null || tree.get(i).isEmpty()) {
            depth += 1;
            dist = 0;
            return;
        }
        for (int c : tree.get(i)) {
            if (used.get(c) == 1)
                continue;
            used.set(c, 1);
            Integer dpth = 0, dst = 0;
            getRes(dpth, dst, tree, used, res, c);
            if (dpth > maxDepth) {
                secMaxDepth = maxDepth;
                maxDepth = dpth;
            } else if (dpth > secMaxDepth) {
                secMaxDepth = dpth;
            }
            if (dst > maxDist) {
                maxDist = dist;
            }
        }
        depth = maxDepth;
        dist = ((maxDepth + secMaxDepth) > maxDist) ? (maxDepth + secMaxDepth) : maxDist;
        res.set(i, dist);
    }
}

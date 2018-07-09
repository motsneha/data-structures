import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumSpanningTree {
    static class Edge {
        int start;
        int end;
        int weight;
        boolean visited;

        public Edge(int start, int end, int weight, boolean visited) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.visited = visited;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return start == edge.start &&
                    end == edge.end &&
                    weight == edge.weight &&
                    visited == edge.visited;
        }

        @Override
        public int hashCode() {

            return Objects.hash(start, end, weight, visited);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {


            int nt = Integer.parseInt(br.readLine());
            for (int t = 0; t < nt; t++) {

                List<Edge> edgeList = new ArrayList<Edge>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                for (int i = 0; i < n; i++) {
                    int[] edgeDetail = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    Edge e = new Edge(edgeDetail[0], edgeDetail[1], edgeDetail[2], false);
                    edgeList.add(e);
                }
                int start = Integer.parseInt(st.nextToken());
                List<Edge> sortedList = edgeList.stream().
                        sorted(Comparator.comparing(Edge::getStart)).
                        sorted(Comparator.comparing(Edge::getWeight).reversed())
                        .collect(Collectors.toList());

                List<Integer> nodes = new ArrayList<>();
               for(Edge edge : sortedList){
                   if(edge.getStart() == start && !edge.isVisited()) {
                       edge.visited = true;
                       nodes.add(edge.getWeight());
                   }
                   start = edge.getEnd();
               }
                nodes.stream().forEach(node -> System.out.println(node));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

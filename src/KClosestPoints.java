import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.awt.*;
import java.util.Arrays;
import java.util.regex.Matcher;

public class KClosestPoints {

    class PointsDistance {
        int[] point;
        double distance;

        PointsDistance(int[] point, long distance) {
            this.distance = distance;
            this.point = point;
        }

        PointsDistance() {
        }

        public int[] getPoint() {
            return point;
        }

        public void setPoint(int[] point) {
            this.point = point;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "PointsDistance{" +
                    "point=" + Arrays.toString(point) +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-2, -4}, {0, 2}, {-1, -4}, {0, 1}, {2, -1}};
        int k = 3;
        KClosestPoints kClosestPoints = new KClosestPoints();
        PointsDistance[] pointsDistances = new PointsDistance[points.length];

        kClosestPoints.findKClosestPoints(points);
    }

    public  void findKClosestPoints(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            double distance = 0;
            double sum = 0;
            PointsDistance pointsDistance = null;
            for (int j = 0; j < 2; j++) {
                sum = sum + Math.pow(points[i][j], 2);
                pointsDistance = new PointsDistance();
                pointsDistance.setPoint(points[i]);
            }

            distance = Math.sqrt(sum);

            pointsDistance.setDistance(distance);
            System.out.println(pointsDistance);
        }
    }
}


import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KNN {
    public static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static ArrayList<Point> getKNN(ArrayList <Point> list, final Point origin, int k){
        if(list.size()< k) {
            return null;
        }
        else if ( list.size() == k) {
            return list;
        }
        PriorityQueue<Point> heap = new PriorityQueue <Point> (
            (a, b) -> (int) ( distance(a, origin) - distance(b, origin) )
        );
        ArrayList <Point> neighbors = new ArrayList <Point> ();
        for(Point p: list) { //O(N)
            heap.add(p);
        }
        while (!heap.isEmpty() && k > 0) { //O(k), upper bound of N
            neighbors.add(heap.poll());
            k--;
        }
        return neighbors;
    }
    public static double distance(Point a, Point b) {
        return Math.sqrt(
            Math.abs(
                Math.pow(a.x - b.x, 2) - Math.pow(a.y - b.y, 2)
            )
        );
    }
    public static void main (String [] args) {
        Point a = new Point(1, 1);
        Point b = new Point(-1, -1);
        Point c = new Point(0, 0);
        Point d = new Point(2, 2);
        Point e = new Point(2, 1);
        Point f = new Point(3, -3);
        Point g = new Point(3, -1);
        Point h = new Point(3, -1);
        Point i = new Point(3, -1);
        Point origin = new Point(0, 0);

        ArrayList <Point> list = new ArrayList <Point>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list = getKNN(list, origin, 8);

        for (Point point : list = getKNN(list, origin, 8)) {
            System.out.println("x-coord: " + (point.x < 0 ? point.x : " " + point.x) + " | y-coord: " + point.y);
        }
    }
}
/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
        
        SLOPE_ORDER = new Comparator<Point>() {
            
            @Override
            public int compare(Point a, Point b) {
                double slope1 = Point.this.slopeTo(a);
                double slope2 = Point.this.slopeTo(b);
                
                if (Double.compare(slope1, slope2) < 0) return -1;
                if (Double.compare(slope1, slope2) > 0) return 1;
                
                return a.compareTo(b);
            }
        };
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        double dx = that.x - x;
        double dy = that.y - y;
        
        /* degenerate case */
        if (dx == 0 && dy == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        
        /* vertical line */
        else if (dx == 0) {
            return Double.POSITIVE_INFINITY;
        }
        
        /* horizontal line */
        else if (dy == 0) {
            return +0.0;
        }
        
        else return dy / dx;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (y < that.y) return -1;
        if (y > that.y) return 1;
        
        if (x < that.x) return -1;
        if (x > that.x) return 1;
        
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}

public class Brute {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            p.draw();
        }
        
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                for (int r = 0; r < N; r++) {
                    for (int s = 0; s < N; s++) {
                        if (points[p].compareTo(points[q]) < 0
                                && points[q].compareTo(points[r]) < 0 
                                && points[r].compareTo(points[s]) < 0) {
                            
                            double slope1 = points[p].slopeTo(points[q]); 
                            double slope2 = points[p].slopeTo(points[r]);
                            double slope3 = points[p].slopeTo(points[s]);
                            
                            if (Double.compare(slope1, slope2) == 0
                                    && Double.compare(slope2, slope3) == 0
                                    && Double.compare(slope1, slope3) == 0) {
                               
                               
                               StdOut.printf("%s -> %s -> %s -> %s\n", 
                                       points[p], points[q], points[r], points[s]);
                                points[p].drawTo(points[s]);
                            }
                        }
                    }
                }
            }
        }
    }
}

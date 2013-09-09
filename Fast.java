import java.util.Arrays;


public class Fast {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        Point[] aux = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            p.draw();
        }
        
        aux = Arrays.copyOf(points, N);
        for (int i = 0; i < N; i++) {
            Point p = points[i];

            Arrays.sort(aux, p.SLOPE_ORDER);
            
            int start = -1, end = -1;
            double prev = 0;
            
            for (int j = 0; j < N; j++) {
                Point q = aux[j];
                
                double slope = p.slopeTo(q);
                
                if (start == -1)
                    start = j;
                
                else if (slope == prev)
                    end = j;
                
                else {
                    
                    if (end - start >= 2 && p.compareTo(aux[start]) <= 0) {
                        StdOut.printf("%s", p);
                        for (int k = start; k <= end; ++k)
                            StdOut.printf(" -> %s", aux[k]);
                        StdOut.printf("\n");
                        p.drawTo(aux[end]);
                    }
                    
                    start = j;
                }
                prev = slope;
            }
        }
    }
}

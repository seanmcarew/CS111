

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        double height = ((Math.sqrt(3))/2)*length;
        return height;

    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double height = height(length);
        double x1 = x + (length/2);
        double y1 = y + height;
        double x2 = x - (length/2);
        double y2 = y + height;
        double[] xArray = {x, x1, x2};
        double[] yArray = {y, y1, y2};
        StdDraw.filledPolygon(xArray,yArray);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        sierpinski(n-1, x-(length/2), y, length/2);
        sierpinski(n-1, x+(length/2), y, length/2);
        sierpinski(n-1, x, y+(height(length)), length/2);

	// WRITE YOUR CODE HERE
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double [] xArray = new double[3];
        xArray[0] = 0;
        xArray[1] = 1;
        xArray[2] = .5;
        double [] yArray = new double[3];
        yArray[0] = 0;
        yArray[1] = 0;
        yArray[2] = height(1);
        StdDraw.polygon(xArray, yArray);
        sierpinski(n, .5, 0, .5);

    }
}

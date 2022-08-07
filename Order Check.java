
public class OrderCheck {

    public static void main(String[] args) {
    double w, x, y, z;
    boolean ascending, descending, isInOrder;

    w = Integer.parseInt(args[0]);
    x = Integer.parseInt(args[1]);
    y = Integer.parseInt(args[2]);
    z = Integer.parseInt(args[3]);
    ascending = ((w<x) && (x<y) && (y<z));
    descending = ((w>x) && (x>y) && (y>z));
    isInOrder = ascending || descending;
    System.out.println(isInOrder);
    }
    
}
**/

public class LargestOfFive {

    public static void main (String[] args) {

        int a, b, c, d, e;
        a =Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        c = Integer.parseInt(args[2]);
        d = Integer.parseInt(args[3]);
        e = Integer.parseInt(args[4]);


        if (a<b)
        {
            a = b;
        }
        if (a<c)
        {
            a = c;
        }
        if (a<d)
        {
            a = d;
        }
        if (a<e)
        {
            a = e;
        }
    System.out.println(a);


    }
}
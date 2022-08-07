
public class RandomWalker 
{

    public static void main(String[] args)
    {
	    int n = Integer.parseInt(args[0]);
        int x = 0; //(0 increases the x coordinate and 1 decreases the x coordinate)
        int y = 0; // (2 increases the y coordinate and 3 decreases the y coordinate)
        System.out.println ("(" + x + "," + y + ")");
        for (int i = 0; i<n; i++)
        {
            int direction = (int) (Math.random() * 4); // going to use a random number with math.random and cast it into an integer so the number can be either 0,1,2,3.
            if (direction == 0)
            {
                x++;
            }
            if (direction == 1)
            {
                x--;
            }
            if (direction == 2)
            {
                y++;
            }
            if (direction == 3)
            {
                y--;
            }
            System.out.println ("(" + x + "," + y + ")");

        }
        double c = ((Math.pow(x, 2)) + (Math.pow(y,2)));
        System.out.println("Squared distance = " + c);
    }

}

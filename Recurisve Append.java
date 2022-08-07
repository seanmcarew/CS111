

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {
        
        if (n == 0)
        {
            return original;
        }
        return original + appendNTimes(original, n-1);
    }

    public static void main (String[] args) {

	String name = "Cat";
    int n = 4;
    System.out.println(appendNTimes(name, 1));
    }
}

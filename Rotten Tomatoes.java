

public class RURottenTomatoes {

    public static void main(String[] args)
    {
        int row = Integer.parseInt(args[0]);
		int column = Integer.parseInt(args[1]);
		int[][] arr = new int [row][column];
        int index = 2;
        int bestrating = 0;
        int sum = 0; // sum of all the ratings for a singular movie
        int bestmovie = 0; // best movie on its sum of ratings
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                arr[i][j] = Integer.parseInt(args[index]);
                index++;
            }
		}
        for (int i = 0; i < column; i++)
        {
            for (int j = 0; j < row; j++)
            {
                sum = sum + arr[j][i];
            }
            if (sum > bestrating)
            {
                bestrating = sum;
                bestmovie = i; 
            }
			sum = 0;
        }
        System.out.println(bestmovie);
    }
    
}
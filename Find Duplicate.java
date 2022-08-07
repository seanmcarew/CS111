

public class FindDuplicate {
    public static void main(String[] args) {
		int n = args.length; //this is to find the length of the array that im imputing
		int[] arr = new int[n]; // using that array length from args, creating a new array the same length as the input array. We are making a new array because the "args" array is a String array and we need an Int array
		int num1; // these numbers are apart of my counter to check if it is true or false
		int num2; // these numberes are apart of my counter to check if it is true or false
		int countertrue = 0; // this counter is to check if there are overlapping numbers, the other way to do this is with a boolean statement

		for (int i = 0; i < n; i++) //using a for loop to cycle through each index of the args array and put it into the integer "arr" array
		{
			arr[i]=Integer.parseInt(args[i]);
		}
		
		for (int i = 0; i < n; i++) // using this for loop to cycle through each numbers initially and check to see if the numbers are equal
		{
			num1 = arr[i];
			for (int j = i+1; j < n; j++) //this nested for loop checks to see if each number is equal to each other by cycling through
			{
				num2 = arr[j];
				if (num1==num2)
				{
					countertrue ++;
				}
			}
		}
		if (countertrue > 0)
		{
			System.out.println(true);
		}
		else System.out.println(false);


	}
}

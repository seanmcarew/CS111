
public class CheckDigit {

    public static void main (String[] args) {
        Long number = Long.parseLong(args[0]); // number inputed by user that is going to be check digit
        long sum = 0; // using sum to calculate number modulus 10 which finds the digit at the right
        long counter = 0; // using counter to add up all the modulus during each loop
        long secondnumber = number / 10; //using command line argument and dividing it by 10 immediately to start checking the second number from the right
        long secondcounter = 0; // using another counter to add up all modulus during each loop
        while (number > 0)
        {
            sum = number % 10;
            counter = counter + sum;
            sum = 0;
            number = number / 100;
        }
        while (secondnumber > 0)
        {
            sum = secondnumber % 10;
            secondcounter = secondcounter + sum;
            sum = 0;
            secondnumber = secondnumber / 100;
        }

    counter = counter % 10;
    secondcounter = secondcounter % 10;
    secondcounter = secondcounter * 3;
    secondcounter = secondcounter % 10;
    long checkdigit = (counter + secondcounter) % 10;

        System.out.print(checkdigit);


    }
}
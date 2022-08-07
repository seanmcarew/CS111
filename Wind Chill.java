

public class WindChill {

    public static void main(String[] args) {
    double temperature, windspeed, Chill;

    Chill=0;
    temperature = Double.parseDouble(args[0]);
    windspeed = Double.parseDouble(args[1]);


    if (Math.abs(temperature) < 50 || windspeed > 3 ||  windspeed < 120)
    {
        Chill = 35.74 + 0.6215 * temperature + ((0.4275 * temperature) - 35.75) * Math.pow(windspeed,0.16);
    }
    else
    {
    System.out.println("ERROR");
    }
    System.out.println(Chill);
    }
}

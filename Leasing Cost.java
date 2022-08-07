public class LeasingCost {
 
     */
	public static Vehicle[] createAllVehicles(String filename) {
        StdIn.setFile(filename);

        int numberOfCars = Integer.parseInt( StdIn.readLine() );
        Vehicle[] vehicles = new Vehicle[numberOfCars];

        for ( int i = 0; i < numberOfCars; i++ ) {
        	String line = StdIn.readLine();
            vehicles[i] = createVehicle(line);
        }
        return vehicles;
    }

    /* 
     * Description:
     *      This method calculates the CO2 emission given several parameters
     * Parameters:
     *      numberOfMonth: 
     *          the lease length in months
     *      usage: 
     *          miles the car can drive per gallon if fuelType is GAS, or
     *			miles the car can drive per kWh    if fuelType is ELECTRIC
     *      mileageAllowance: 
     *			mileage allowance per month
     *		co2PerUnit:
     *			kg of CO2 released with the combustion of each gallon of gasoline, or
     *			kg of CO2 are emitted to generate 1 kWh on average
     * Returns:
     *      this method returns a double representing the CO2 emission produced by the car during the lease.
     */
	public static double computeCO2(double numberOfMonth, double usage, double mileageAllowance, double co2PerUnit ){
		double miles = numberOfMonth * mileageAllowance ;
		return miles/usage*co2PerUnit;
    }

    /* 
     * Description:
     *      This method calculates the cost the fuel during the lease given several parameters
     * Parameters:
     *      numberOfMonth: 
     *          the lease length in months
     *      usage: 
     *          miles the car can drive per gallon if fuelType is GAS, or
     *			miles the car can drive per kWh    if fuelType is ELECTRIC
     *      mileageAllowance: 
     *			mileage allowance per month
     *		fuelPrice: 
     *			price of 1 kWh in cents of a dollar,  if fuelType is GAS, or
     *			price of one gallon of gas in dollars if fuelType is ELECTRIC
     * Returns:
     *      this method returns a double representing the fuel cost during the lease
     */
	public static double computeFuelCost(double numberOfMonth, double usage, double mileageAllowance, double fuelPrice){
    	double miles = numberOfMonth * mileageAllowance;
        double cost = miles/usage * fuelPrice;
    	return cost;
    }

    /* 
     * Description:
     *      This method calculates the cost of lease
     * Parameters:
     *      dueAtSigning: 
     *          the dollar amount due at signing the lease
     *      numberOfMonths: 
     *          lease length in months
     *      monthlyCost: 
     *			cost of the lease per month
     * Returns:
     *      this method returns a double representing the lease cost during the entire lease
     */
	public static double computeLeaseCost(double dueAtSigning, int numberOfMonths, double monthlyCost){
    	
        return dueAtSigning + numberOfMonths*monthlyCost;
    }

    /* 
     * Description:
     *      This method creates and returns an Vehicle object with name, Lease, and Fuel properly populated based on the given string
     *      
     * Parameters:
     *      one string containing 7~8 fragments descrbing the 
     *   All possible fragments:
     *      type:FULETYPE;
     *          FULETPE can be gas or electric
     *      name:CARNAME;
     *          CARNAME is the name of the car
     *      due:DUEATSIGNING;
     *          DUEATSIGNING is a double number describing the dollar amount due when signing the lease
     *      length:LEASELENGTH;
     *          LEASELENGTH is an integer number describing the lease length in months
     *      monthly:MONTHLYCOST;
     *          MONTHLYCOST is a double number describing the monthly lease cost in dollar
     *      mile/unit:USAGE; 
     *          USAGE is a double describing miles the car can drive per gallon if fuel type is GAS, or miles the car can drive per kWh if fuel type is ELECTRIC
     *      allowance:MILEAGEALLOWANCE;
     *          MILEAGEALLOWANCE is an integer describing the maximum distance the car is allowed to travel per month
     *      charger:CHARGERCOST;
     *          CHARGERCOST is a double describing the cost of charger for electric cars, this fragment can only appear if the line is describing an electrical car
     *   Example of a line:
     *          type:gas.name:civic.due:1000.length:3.monthly:295.mile/unit:34.mileageAllowance:1200.
     *          monthly:238.name:Bolt.due:1000.mileageAllowance:20000.length:15.mile/unit:50.type:electric.charger:500.
     * Returns:
     *      this method creates and returns an Vehicle object with name, Lease, and Fuel properly populated
     *
     * Hint: 
     *      to extract the information of each fragments, we can use 
     *          s.substring(int startIndex, int endIndex) 
     *          s.indexOf(String target)
     *          s.indexOf(char target)
     *
     *      for example, assume we have: 
     *          String s = "description1:ABCD;  description2:EFGH;  description3:IJKL;"
     *      if we want to find the data for description 2, we can first take the substring of the entire string from the letter 'E'
     *      but first we need to find the index of 'E', we can do it by find the index of the string "description2:" and add 13("description2" is 13 chars long)to it
     *      and then we can take the substring from 'E' until the end of the entire string
     *      now use s.substring to extract:
     *          "EFGH;  description3:IJKL;" and let's call it newString for now. 
     *      to extract "EFGH" (the data we want) from newString. we need to find the index of the first ';' which we can simply use newString.indexOf(';')
     *      then we can take the substring of the newString knowing the index of ;
     *      we now have extracted "EFGH" from the String s
     *      the last step is just to convert the datatype based on what type of data we are extracting
     */
	public static Vehicle createVehicle(String description){
        int indexName = (description.indexOf("name:") + 5); 
        String nametest = description.substring(indexName); 
        int indexNameEnd = (nametest.indexOf(';')); 
        String name = nametest.substring(0, indexNameEnd);

        int indexUsage = (description.indexOf("mile/unit:") + 10); 
        String usageTest = description.substring(indexUsage); 
        int indexUsageEnd = (usageTest.indexOf(';')); 
        String usageString = usageTest.substring(0, indexUsageEnd);
        double usage = Double.parseDouble(usageString);

        int indexLease = (description.indexOf("due:") + 4); 
        String leaseTest = description.substring(indexLease); 
        int indexLeaseEnd = (leaseTest.indexOf(';')); 
        String leaseString = leaseTest.substring(0, indexLeaseEnd);
        double dueAtSigning = Double.parseDouble(leaseString);

        int indexType = (description.indexOf("type:") + 5); 
        String typeTest = description.substring(indexType); 
        int indexTypeEnd = (typeTest.indexOf(';')); 
        String type = typeTest.substring(0, indexTypeEnd);

        int indexLeaseLength = (description.indexOf("length:") + 7); 
        String leaseLengthTest = description.substring(indexLeaseLength); 
        int indexLeaseLengthEnd = (leaseLengthTest.indexOf(';')); 
        String leaseLengthString = leaseLengthTest.substring(0, indexLeaseLengthEnd);
        int leaseLength = Integer.parseInt(leaseLengthString);

        int indexMonthly = (description.indexOf("monthly:") + 8); 
        String monthlyTest = description.substring(indexMonthly); 
        int indexMonthlyEnd = (monthlyTest.indexOf(';')); 
        String monthlyString = monthlyTest.substring(0, indexMonthlyEnd);
        double monthlyCost = Double.parseDouble(monthlyString);

        int indexAllowance = (description.indexOf("allowance:") + 10); 
        String allowanceTest = description.substring(indexAllowance); 
        int indexAllowanceEnd = (allowanceTest.indexOf(';')); 
        String allowanceString = allowanceTest.substring(0, indexAllowanceEnd);
        int mileageAllowance = Integer.parseInt(allowanceString);

        Fuel fuel;
        String electric = "electric";
        if (type.equals(electric))
        {
            int indexCharger = (description.indexOf("charger:") + 8); 
            String chargerTest = description.substring(indexCharger); 
            int indexChargerEnd = (chargerTest.indexOf(';')); 
            String chargerString = chargerTest.substring(0, indexChargerEnd);
            double charger = Double.parseDouble(chargerString);

            fuel = new Fuel(usage, charger);
        }
        else
        {
            fuel = new Fuel(usage);
        }

        Lease createLease = new Lease(dueAtSigning, leaseLength, monthlyCost, mileageAllowance);
        Vehicle createVehicle = new Vehicle(name, fuel, createLease);
	    return createVehicle;
	}

    /* 
     * Description:
     *      The method calculates and assign CO2Emission, FuelCost, leastCost, of each vehicle.
     *      
     * Parameters:
     *      vehicles: 
     *          an array of Vehicle objects, initilized by getVehicles() method
     *      gasPrice: 
     *          a double representing the price of gas in dollar/gallon
     *      electricityPrice: 
     *			a double representing the price of gas in dollar/kWh
     * Hint:
     *      **********REMEMBER charger cost for electric cars***************
     *      feel free to use:
     *          computeCO2(double numberOfMonth, double usage, double mileageAllowance, double co2PerUnit )
     *          computeFuelCost(double numberOfMonth, double usage, double mileageAllowance, double fuelPrice)
     *          computeLeaseCost(double dueAtSigning, int numberOfMonths, double monthlyCost)
     */
	public static void computeCO2EmissionsAndCost( Vehicle[] vehicles, double gasPrice, double electricityPrice ){
        double leaseCost = 0;
        double emissions = 0;
        double CO2Constant = 8.887;
        double unitConversions = .453;
        for ( int i = 0; i < vehicles.length; i ++ )
        {
            double leaseLength = vehicles[i].getLease().getLeaseLength();
            double miles = vehicles[i].getLease().getMileageAllowance() * leaseLength;
            double milesPerUnit = vehicles[i].getFuel().getUsage();

            double unitCost = gasPrice;
            double monthLeaseCost = vehicles[i].getLease().getMonthlyCost();
            if (vehicles[i].getFuel().getType() == 1)
            {
                emissions = miles / milesPerUnit * CO2Constant;
                leaseCost = (monthLeaseCost * leaseLength)  + vehicles[i].getLease().getDueAtSigning();
            }
            else if(vehicles[i].getFuel().getType() == 2)
            {
                double kwhPerCharge = vehicles[i].getFuel().getCharger();
                emissions = miles/milesPerUnit * unitConversions;
                unitCost = electricityPrice;
                leaseCost = (monthLeaseCost * leaseLength) + vehicles[i].getLease().getDueAtSigning() + kwhPerCharge;
            }
            
            vehicles[i].setCO2Emission(emissions);
            double fuelCost = (miles/milesPerUnit) * unitCost;
            vehicles[i].setFuelCost(fuelCost);
            double totalCost = leaseCost + fuelCost;
            vehicles[i].setTotalCost(totalCost);
        }
    	}


    /**
     * How to compile:
     *     javac LeasingCost.java
     * How to run:         
     *     java LeasingCost vehicles.txt 3.85 11.0
     **/
	public static void main (String[] args) {
        String filename         = args[0];
        double gasPrice 		= Double.parseDouble( args[1] );
		double electricityPrice = Double.parseDouble( args[2] );

		Vehicle[] vehicles = createAllVehicles(filename); 
		computeCO2EmissionsAndCost(vehicles, gasPrice, electricityPrice);

		for ( Vehicle v : vehicles ) 
            System.out.println(v.toString());
    }
}

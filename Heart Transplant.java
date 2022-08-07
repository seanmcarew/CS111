
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {

        for ( int i = 0; i < this.patients.length; i ++ )
        {
            this.patients[i] = null;
        }
        this.survivabilityByAge = null;

        this.survivabilityByCause = null;    
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {

        return this.patients;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return this.survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return this.survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {

        Patient[] patient = new Patient[numberOfLines];

        for ( int i = 0; i < numberOfLines; i ++ ){
            int id = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();
            Patient p = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
            patient[i] = p;
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        this.survivabilityByAge = new SurvivabilityByAge();
        for ( int i = 0; i < numberOfLines; i ++ )
        {
            int age = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            this.survivabilityByAge.addData(age, year, rate);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        this.survivabilityByCause = new SurvivabilityByCause();
        for ( int i = 0; i < numberOfLines; i ++ )
        {
            int cause = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            this.survivabilityByCause.addData(cause, year, rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {

        int numPatientsOlderThanAge = 0;
        for ( int i = 0; i < patients.length; i++ )
        {
            int x = patients[i].getAge();
            if (x >= age)
            {
                numPatientsOlderThanAge ++;
            }
        }
        if (numPatientsOlderThanAge == 0)
        {
            return null;
        }
        Patient[] filteredAge = new Patient[numPatientsOlderThanAge];
        int counter = 0;
        for ( int j = 0; j < patients.length; j ++ )
        {
            if (patients[j].getAge() >= age)
            {
                filteredAge[counter] = patients[j];
                counter++;
            }
        }
        return filteredAge;
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int numPatientsByHeart = 0;
        for ( int i = 0; i < patients.length; i ++ )
        {
            if (patients[i].getCause() == cause) numPatientsByHeart ++;
        }
        if (numPatientsByHeart == 0) return null;
        Patient[] filteredCause = new Patient[numPatientsByHeart];
        int counter = 0;
        for ( int j = 0; j < patients.length; j ++ )
        {
            if (patients[j].getCause() == cause)
            {
                filteredCause[counter] = patients[j];
                counter ++;
            }
        }
        return filteredCause;
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int numPatientsUrgency = 0;
        for ( int i = 0; i < patients.length; i ++ )
        {
            if (patients[i].getStateOfHealth() == urgency){
                numPatientsUrgency ++;
            }
            if (numPatientsUrgency == 0)
            {
                return null;
            }
        }
        Patient[] urgencyPatients = new Patient [numPatientsUrgency];
        int counter = 0;
        for ( int j = 0; j < patients.length; j ++)
        {
            if (patients[j].getStateOfHealth() == urgency)
            {
                urgencyPatients[counter] = patients[j];
                counter ++;
            }
         }
         return urgencyPatients;
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {
        double averageFinal = (survivabilityByAge.getRate(patients[0].getAge(), patients[0].getUrgency())+ survivabilityByCause.getRate(patients[0].getCause(),patients[0].getUrgency())) / 2;
        int counter = 0;
        for ( int i = 0; i < patients.length; i ++ )
        {
            double byAge = survivabilityByAge.getRate(patients[i].getAge(), patients[i].getUrgency());
            double byCause = survivabilityByCause.getRate(patients[i].getCause(),patients[i].getUrgency());
            double average = (byAge + byCause)/2;
            if ( average > averageFinal )
            {
                averageFinal = average;
                counter = i;
            }
        }
        boolean false1 = false;
        boolean heart = patients[counter].getNeedHeart();
        false1 = heart;
        return patients[counter];
    }
}

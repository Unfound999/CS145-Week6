import java.util.*;

public class FindCD {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        //Collecting user input
        System.out.print("Please enter numerator of first fraction: ");
        int firstNumerator = input.nextInt();

        System.out.print("Please enter denominator of first fraction: ");
        int firstDenominator = input.nextInt();

        System.out.print("Please enter numerator of second fraction: ");
        int secondNumerator = input.nextInt();

        System.out.print("Please enter denominator of second fraction: ");
        int secondDenominator = input.nextInt();

        //This code calculates the LCM of the denominators
        int GCD = calculateGCD(firstDenominator, secondDenominator);
        int LCM = ((firstDenominator * secondDenominator) / GCD);

        //This code adjusts the numerators to their new values
        int firstFinalNumerator = firstNumerator * (LCM / firstDenominator);
        int secondFinalNumerator = secondNumerator * (LCM / secondDenominator);

        //This print statement displays the adjusted fractions with their new common denominator
        System.out.print("The two fractions with a common denominator are: " + firstFinalNumerator + "/" + LCM + " and " + secondFinalNumerator + "/" + LCM);
        
    }
    
    //This method uses the euclidean algorithm to calculate the GCD
    public static int calculateGCD(int firstD, int secondD) {

        if(secondD == 0) {
            return firstD;
        }
        return calculateGCD(secondD, firstD % secondD);
    }

}
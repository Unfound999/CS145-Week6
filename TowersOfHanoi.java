import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersOfHanoi {
    
    public static void main(String[] args) throws NullPointerException{

        //  initializes variables
        int diskAmount = 0;
        String source = "towerA";
        String dest = "towerC";
        String aux = "towerB";   
        Scanner input = new Scanner(System.in);

        //  prompts user for amount of disks
        do {
            System.out.println("Please enter the total amount of disks: ");
            try {
                diskAmount = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid number, please enter a valid number: ");
                input.next();
            } // end of try catch
        } while (diskAmount == 0);

        hanoiSolve(diskAmount, source, dest, aux);
    } //  end of main method

    public static void hanoiSolve(int diskAmount, String source, String dest, String aux) {

        if (diskAmount == 0) {
            return;
        } //  end of if loop

        hanoiSolve(diskAmount-1, source, aux, dest);
        System.out.printf("%s%d%s%s%s%s%n", "Moved disk ", diskAmount, " from ", source, " to ", dest);
        hanoiSolve(diskAmount-1, aux, dest, source);

    } // end of hanoiSolve method
} //  end of TowersOfHanoi class
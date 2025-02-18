import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersOfHanoi {
    
    public static void main(String[] args) throws NullPointerException{

        //  initializes variables
        HashMap<String, Integer> towers = new HashMap<String, Integer>();
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

        towers.put("towerA", diskAmount);
        towers.put("towerB", 0);
        towers.put("towerC", 0);

        hanoiSolve(diskAmount, source, dest, aux, towers);
    } //  end of main method

    public static void hanoiSolve(int diskAmount, String source, String dest, String aux, HashMap<String, Integer> towers) {

        if (diskAmount == 0) {
            return;
        } //  end of if loop

        hanoiSolve(diskAmount-1, source, aux, dest, towers);
        towers.put(source, towers.get(source) - 1);
        towers.put(dest, towers.get(dest) + 1);
        System.out.printf("%s%d%s%s%s%s%n", "Moved disk ", diskAmount, " from ", source, " to ", dest);
        hanoiSolve(diskAmount-1, aux, dest, source, towers);

    } // end of hanoiSolve method
} //  end of TowersOfHanoi class
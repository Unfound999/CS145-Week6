import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersOfHanoi {

    ArrayList<Integer> towerA = new ArrayList<Integer>();
    ArrayList<Integer> towerB = new ArrayList<Integer>();
    ArrayList<Integer> towerC = new ArrayList<Integer>();
    
    public static void main(String[] args) throws NullPointerException{

        //  initializes variables
        ArrayList<Integer> towerA = new ArrayList<Integer>();
        ArrayList<Integer> towerB = new ArrayList<Integer>();
        ArrayList<Integer> towerC = new ArrayList<Integer>();
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

        //  places disks in towerA
        for (int i = 0; diskAmount > i; i++) {
            towerA.add(i+1);
            towerB.add(0);
            towerC.add(0);
        } //  end of for loop

        //  sorts towerA disks in correct order for start of game
        Collections.sort(towerA);
        Collections.sort(towerB);
        Collections.sort(towerC);
        System.out.println(); 
        hanoiSolve(diskAmount, towerA, towerB, towerC, source, dest, aux);
    } //  end of main method

    public static void menu(int diskAmount, ArrayList<Integer> towerA, ArrayList<Integer> towerB, ArrayList<Integer> towerC) {
        for (int i = 0; diskAmount > i; i++) {
            System.out.printf("%d%s", towerA.get(i), " ");
            System.out.printf("%d%s", towerB.get(i), " ");
            System.out.printf("%d%s%n", towerC.get(i), " ");
        } //  end of for loop
        System.out.println("A B C");
    } //  end of menu method

    public static void hanoiSolve(int diskAmount, ArrayList<Integer> towerA, ArrayList<Integer> towerB, ArrayList<Integer> towerC, String source, String dest, String aux) {

        if (diskAmount == 0) {
            return;
        } //  end of if loop

        hanoiSolve(diskAmount-1, towerA, towerB, towerC, source, aux, dest);
        System.out.printf("%s%d%s%s%s%s%n", "Moved disk ", diskAmount, " from ", source, " to ", dest);
        hanoiSolve(diskAmount-1, towerA, towerB, towerC, aux, dest, source);

    } // end of hanoiSolve method
} //  end of TowersOfHanoi class
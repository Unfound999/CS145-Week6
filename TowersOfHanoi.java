//  Authors: Brody Weinkauf
//  Purpose: Program takes in user inputted number to create and solve a Tower of Hanoi puzzle
//  Assignment: CS145: Assignment 7 - Recursion
//  Extra Credit: For extra credit, I utilized zero iterative loops, using only recursion for this program.
//                A try-catch is utilized to handle Scanner input.
//                A test UI was created to visualize each step of the Towers of Hanoi
//                A HashMap is utilized to store the towers and each tower's respective amount of disks.

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowersOfHanoi {
    
    public static void main(String[] args) {

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

        //  places disks into towers; the integer value equals the amount of disks on the tower
        towers.put("towerA", diskAmount);
        towers.put("towerB", 0);
        towers.put("towerC", 0);

        //  solves Tower of Hanoi puzzle
        hanoiSolve(diskAmount, source, dest, aux, towers, diskAmount);
    } //  end of main method

    //  solves the Tower of Hanoi puzzle step-by-step using recursion
    public static void hanoiSolve(int diskAmount, String source, String dest, String aux, HashMap<String, Integer> towers, int maxDisk) {

        //  base condition
        if (diskAmount == 0) {
            return;
        } //  end of if loop

        // hanoiSolve calls itself
        hanoiSolve(diskAmount-1, source, aux, dest, towers, maxDisk);

        // for each step, removes one disk from source tower and adds one disk to destination tower
        towers.put(source, towers.get(source) - 1);
        towers.put(dest, towers.get(dest) + 1);

        /* in order to create a visual of the three towers and their respective disks for each step an independent integer value from the
         * HashMap "towers" must be intialized and passed into hanoiUI method. */
        int towerAHeight = towers.get("towerA");
        int towerBHeight = towers.get("towerB");
        int towerCHeight = towers.get("towerC");

        //  prints an empty line for better UI experience
        System.out.println();

        /* prints visual of towers for each step
         * prints what disk was moved, where the disk came from, and where the disk was moved to
         * hanoiSolve calls itself */
        hanoiUI(maxDisk, maxDisk, towerAHeight, towerBHeight, towerCHeight);
        System.out.printf("%s%d%s%s%s%s%n", "Moved disk ", diskAmount, " from ", source, " to ", dest);
        hanoiSolve(diskAmount-1, aux, dest, source, towers, maxDisk);
    } // end of hanoiSolve method

    //  creates and prints visual of towers and each tower's respective disk to user
    public static void hanoiUI(int maxDisk, int heightMax, int towerAH, int towerBH, int towerCH) {

        //  base condition
        if (maxDisk == 0) {
            System.out.println("A B C");
            return;
        } //  end of if statement
        
        /* if a tower has a height value smaller than the total amount of disks, print a 0 and add 1 to the height value
         * if a tower has a height value larger than the total amount of disks, print a square
         * these if-else statements ensure that the correct amount of disks are printed in the correct towers */
        if (towerAH < heightMax) {
            System.out.printf("%d%s", 0, " ");
            towerAH++;
        } else {
            System.out.printf("%s", "\u25A0 ");
        } //  end of if-else statement

        if (towerBH < heightMax) {
            System.out.printf("%d%s",  0, " ");
            towerBH++;
        } else {
            System.out.printf("%s", "\u25A0 ");
        } //  end of if-else statement

        if (towerCH < heightMax) {
            System.out.println(0);
            towerCH++;
        } else {
            System.out.println( "\u25A0");
        } //  end of if-else statement

        //  hanoiUI calls itself
        hanoiUI(maxDisk-1, heightMax, towerAH, towerBH, towerCH);
    } //  end of hanoiUI method
} //  end of TowersOfHanoi class
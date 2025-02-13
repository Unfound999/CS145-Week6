import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TowersOfHanoi {

    public static void main(String[] args) throws NullPointerException{

        //  initializes variables
        ArrayList<Integer> towerA = new ArrayList<Integer>();
        ArrayList<Integer> towerB = new ArrayList<Integer>();
        ArrayList<Integer> towerC = new ArrayList<Integer>();   
        Scanner input = new Scanner(System.in);

        //  prompts user for amount of disks
        System.out.println("Please enter the amound of disks");
        int diskAmount = input.nextInt();

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
        menu(diskAmount, towerA, towerB, towerC);
    } //  end of main method

    public static void menu(int diskAmount, ArrayList<Integer> towerA, ArrayList<Integer> towerB, ArrayList<Integer> towerC) {
        for (int i = 0; diskAmount > i; i++) {
            System.out.printf("%d%s", towerA.get(i), " ");
            System.out.printf("%d%s", towerB.get(i), " ");
            System.out.printf("%d%s%n", towerC.get(i), " ");
        } //  end of for loop
        System.out.println("A B C");
    } //  end of menu method
} //  end of TowersOfHanoi class

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

        //  user menu for game
        for (int i = 0; diskAmount > i; i++) {
            System.out.print(towerA.get(i));
            System.out.print(towerB.get(i));
            System.out.println(towerC.get(i));
        } //  end of for loop
    } //  end of main method
} //  end of TowersOfHanoi class

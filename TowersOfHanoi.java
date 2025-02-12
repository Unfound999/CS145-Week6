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
        } //  end of for loop

        //  sorts towerA disks in correct order for start of game
        Collections.sort(towerA, Collections.reverseOrder());

        //  test line for order of disks in towerA
        System.out.print(towerA);
    } //  end of main method
} //  end of TowersOfHanoi class

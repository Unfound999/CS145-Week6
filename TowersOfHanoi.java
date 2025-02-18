//  TO DO: remove original iterative version of hanoiUI method & change name of "hanoiUITest" method
//         Clean up code formatting a bit
//         Add comments
//         Add header comments at top of program


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

        hanoiSolve(diskAmount, source, dest, aux, towers, diskAmount);
    } //  end of main method

    public static void hanoiSolve(int diskAmount, String source, String dest, String aux, HashMap<String, Integer> towers, int maxDisk) {

        if (diskAmount == 0) {
            return;
        } //  end of if loop

        hanoiSolve(diskAmount-1, source, aux, dest, towers, maxDisk);
        towers.put(source, towers.get(source) - 1);
        towers.put(dest, towers.get(dest) + 1);
        int towerAHeight = towers.get("towerA");
        int towerBHeight = towers.get("towerB");
        int towerCHeight = towers.get("towerC");
        System.out.println();
        hanoiUITest(towers, maxDisk, maxDisk, towerAHeight, towerBHeight, towerCHeight);
        System.out.printf("%s%d%s%s%s%s%n", "Moved disk ", diskAmount, " from ", source, " to ", dest);
        hanoiSolve(diskAmount-1, aux, dest, source, towers, maxDisk);

    } // end of hanoiSolve method

    public static void hanoiUI (HashMap<String, Integer> towers, int maxDisk) {
        
        int towerAHeight = towers.get("towerA");
        int towerBHeight = towers.get("towerB");
        int towerCHeight = towers.get("towerC");
        
        System.out.println();

        for (int i = 0; i < maxDisk; i++) {
            if (towerAHeight < maxDisk) {
                System.out.printf("%d%s", 0, " ");
                towerAHeight++;
            } else {
                System.out.printf("%d%s", 1, " ");
            }
            if (towerBHeight < maxDisk) {
                System.out.printf("%d%s", 0, " ");
                towerBHeight++;
            } else {
                System.out.printf("%d%s", 1, " ");
            }
            if (towerCHeight < maxDisk) {
                System.out.println(0);
                towerCHeight++;
            } else {
                System.out.println( 1);
            }
        }
    }

      public static void hanoiUITest(HashMap<String, Integer> towers, int maxDisk, int heightMax, int towerAH, int towerBH, int towerCH) {

        if (maxDisk == 0) {
            return;
        }
        
        if (towerAH < heightMax) {
            System.out.printf("%d%s", 0, " ");
            towerAH++;
        } else {
            System.out.printf("%d%s", 1, " ");
        }
        if (towerBH < heightMax) {
            System.out.printf("%d%s", 0, " ");
            towerBH++;
        } else {
            System.out.printf("%d%s", 1, " ");
        }
        if (towerCH < heightMax) {
            System.out.println(0);
            towerCH++;
        } else {
            System.out.println( 1);
        }

        hanoiUITest(towers, maxDisk-1, heightMax, towerAH, towerBH, towerCH);

    } 

} //  end of TowersOfHanoi class
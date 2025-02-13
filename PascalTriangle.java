import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalTriangle {

    /**
     *  Recursively processes the cells for a row in our triangle.
     * @param priorRow The row we're using to get the addition for our new cells
     * @param currRow The array we're adding our new cells too.
     * @param index The index of which cell we are currently working on.
     * @return The next index that should be worked on.
     */
    public static int processCells(int[] priorRow, int[] currRow, int index) {
        // Only recurse if our index is greater than zero.
        if (index > 0) {
            index = processCells(priorRow, currRow, index - 1); // Recurse at the next lower index.
        }

        // If our index is zero, or we're at the end of the array, assign the value of 1 in line with Pascal's Triangle.
        if (index == 0 || index == currRow.length - 1) {
            currRow[index] = 1;
            return index + 1;
        }
        currRow[index] = priorRow[index] + priorRow[index - 1];
        return index + 1;
    }

    /**
     * Recursively Processes each row we want in our triangle.
     * @param triangle Our 2d Array that represents the triangle.
     * @param priorRow The previous row processed, used for values in the cells.
     * @param rowCount How many rows are in this triangle.
     * @return Returns itself, to recurse in the next loop as the prior row.
     */
    public static int[] processRow(int[][] triangle, int[] priorRow, int rowCount) {
        if (rowCount == 0) {
            int[] newRow = new int[] { 1 };
            triangle[rowCount] = newRow;
            return newRow;
        }
        priorRow = processRow(triangle, priorRow, rowCount - 1);
        int[] row = new int[priorRow.length + 1];
        processCells(priorRow, row, row.length - 1);
        // forSketch(priorRow, row);
        triangle[rowCount] = Arrays.copyOf(row, row.length);
        return row;
    }

    public static void printCell(int[] row, int index) {
        if (index != 0) {
            printCell(row, index - 1);
        }
        if (index == row.length - 1) {
            System.out.printf("|%d|\n", row[index]);
        } else {
            System.out.printf("|%d| ", row[index]);
        }
    }

    public static void printTab(int tabCount) {
        if (tabCount != 0) {
            printTab(tabCount - 1);
        }
        System.out.print("  ");
    }

    public static void printRow(int[][] triangle, int rowCount, int tabCount) {
        if (rowCount != 0) {
            printRow(triangle, rowCount - 1, tabCount + 1);
        }
        printTab(tabCount);
        printCell(triangle[rowCount], triangle[rowCount].length - 1);
    }

    public static void createTriangle(int size) {
        int[][] triangle = new int[size][];
        processRow(triangle, null, triangle.length - 1);
        printRow(triangle, triangle.length - 1, 0);

    }

    public static void main(String[] args) {
        Integer size = null;
        do {
            System.out.print("How many layers do you want your triangle?> ");
            try {
                Scanner intScanner = new Scanner(System.in);
                size = intScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please only enter numbers.");
            }
        } while (size == null);
        createTriangle(size);
    }
}
import java.util.Scanner;

/**
 * This Class can make a Multiplication Table
 */
public class MultiplicationTable {

    /**
    * tableGen creates a multiplication table with one user inputed list.
    */
    public void tableGen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a comma-separated list of numbers");

        String userInput = scanner.nextLine();
        String[] parts = userInput.split("\\s*,\\s*");
        int[] numbers = new int[parts.length + 1];
        numbers[0] = 0;

        try {
            for (int i = 0; i < parts.length; i++) {
                numbers[i + 1] = Integer.parseInt(parts[i].trim());
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Please enter a valid comma-separated list of numbers.");
            scanner.close();
            return;
        }

        int[][] twoD = new int[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) { 
                twoD[i][j] = numbers[i] * numbers[j];
                if (i == 0){
                    twoD[0][j] = numbers[j];
                } else if (j==0) {
                    twoD[i][0] = numbers[i];
                }
            }
        }

        System.out.println();

        print2D(twoD);
        scanner.close();
    }

    /**
    * print2D prints out a 2d array.
    */
    public void print2D(int[][] arr) { 
        for (int[] row : arr) {
            for (int value : row) { 
                System.out.print(value + " "); // Use print instead of println to print elements in the same line
            }
            System.out.println(); 
        }
    }

    /**
    * tableGen2 creates a multiplication table with two user inputed lists.
    */
    public void tableGen2(){
        Scanner scanner = new Scanner(System.in);

        //First row.
        System.out.println("Give me a comma-separated list of numbers (vertical)");

        String userInput1 = scanner.nextLine();

        String[] parts1 = userInput1.split("\\s*,\\s*");
        int[] numbers1 = new int[parts1.length + 1];

        //Second row.
        System.out.println("Give me a comma-separated list of numbers (horizontal)");

        String userInput2 = scanner.nextLine();

        String[] parts2 = userInput2.split("\\s*,\\s*");
        int[] numbers2 = new int[parts2.length + 1];

        try {
            for (int i = 0; i < parts1.length; i++) { //First row.
                numbers1[i + 1] = Integer.parseInt(parts1[i].trim());
            }
            for (int i = 0; i < parts2.length; i++) { //Second row.
                numbers2[i + 1] = Integer.parseInt(parts2[i].trim());
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Please enter a valid comma-separated list of numbers.");
            scanner.close();
            return;
        }

        int[][] twoD = new int[numbers1.length][numbers2.length];

        for (int i = 0; i < numbers1.length; i++) {
            for (int j = 0; j < numbers2.length; j++) { 
                twoD[i][j] = numbers1[i] * numbers2[j];
                if (i == 0){
                    twoD[0][j] = numbers2[j];
                } else if (j==0) {
                    twoD[i][0] = numbers1[i];
                }
            }
        }

        System.out.println();

        print2D(twoD);
        scanner.close();
    }

    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test table 1 or table 2? (1 or 2)");

        String theInput = scanner.nextLine();

        if (theInput.equals("1")){
            table.tableGen();
        } else if (theInput.equals("2")){
            table.tableGen2();
        } else {
            System.out.println("Invalid input");
        }

        scanner.close();

    }
    
}


import java.util.Scanner;
import java.lang.Integer;
/**
 * Class that takes a number of number of numbers from the 
 * command line and prints them back to the user
 */
public class Main{

    public static Scanner scanner = new Scanner(System.in); 

    /**
     * Main function that runs the program, it takes input from the command line
     * and asks the user to input that many numbers from the command line.
     * It then prints the provided numbers back to the user.
     *
     * @param args The number of numbers to be input in the program
     * @return void
     */
    public static void main(String[] args) {
        System.out.println("Let's do this!");
        if (args.length == 1) {
            int number = Integer.parseInt(args[0]);
            System.out.println("We are doing it for " + number + " numbers.");
            int[] myInts = getIntegers(number);
            int counter = 1;
            for (int i : myInts) {
               System.out.println("Integer " + counter++ + " was " + i);
            }
        }
        else {
            System.out.println("Dude, we only want one argument. Exactly one, but we got " + (args.length));
            return;
        }
	}
    /**
     * Function that asks the user to input numbers from the 
     * command line.
     *
     * @param number How many numbers to ask the user to provide.
     * @return An array of integers.
     */
    private static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values\r");
        int[] arr = new int[number];

        for (int i=0; i<number; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}

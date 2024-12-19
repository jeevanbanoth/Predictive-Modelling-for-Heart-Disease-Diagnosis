package kSmall;

import java.util.*;

public class KSmallTester {

    public final static int SIZE_OF_ARRAY = 10;
    public final static String PROMPT = "Please enter an integer k, 1 <= k <= " +
            SIZE_OF_ARRAY + ", or 'R' to refill the array, or 'Q' to quit: ";

    public static void printArray(int[] array) {
        System.out.println("array = [" + Arrays.toString(array) + "]");
        System.out.println("--------------------------------------------------------------------");
    }

    public static void randFillArray(int[] array) {
        Random random = new Random();

        for (int i = 0; i < SIZE_OF_ARRAY; i++)
            array[i] = random.nextInt(100);
    }

    public static void main(String argv[]) {
        int[] array = new int[SIZE_OF_ARRAY];
        int[] arrayTmp = new int[SIZE_OF_ARRAY];

        Scanner scanner = new Scanner(System.in);

        randFillArray(array);
        printArray(array);
        arrayTmp = array.clone(); // deep copy

        while (true) {
            System.out.print(PROMPT);
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                break;
            } else if (input.equalsIgnoreCase("R")) {
                randFillArray(array);
                arrayTmp = array.clone(); // deep copy
                printArray(array);
            } else {
                try {
                    int k = Integer.parseInt(input);
                    if (k >= 1 && k <= SIZE_OF_ARRAY) {
                        int kthSmallest = KthSmallest.kSmall(k, arrayTmp, 0, SIZE_OF_ARRAY - 1);
                        System.out.println("The " + k + (getKthSuffix(k)) + " smallest item is " + kthSmallest);
                        //System.out.print("Try again? Press 'Enter' to continue, or 'Q' to quit: ");
                    } else {
                        System.out.println("Invalid input. Please enter a valid k.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid k, 'R', or 'Q'.");
                }
            }
            //prints the line in between every command
            System.out.println("--------------------------------------------------------------------");
        }

        scanner.close();
    }

    public static String getKthSuffix(int k) {
        if (k == 1) return "st";
        if (k == 2) return "nd";
        if (k == 3) return "rd";
        return "th";
    }
}

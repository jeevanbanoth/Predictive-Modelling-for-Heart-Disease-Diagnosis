import java.util.Scanner;
public class AckerFunction {

    private static int spaces = 0;
    private static int numberOfInvocations = 0;

    // Getter for data field "numberOfInvocations"
    public static int countOfInvocations(){
        return numberOfInvocations;
    }

    public static int acker(int m, int n){
        int result;

        // Increase the number of invocations and print the "Enter" message
        numberOfInvocations++;
        printSpaces();
        System.out.println("Enter method acker: m = " + m + ", n = " + n);
        
        // Base case
        if (m == 0) {
            result = n + 1;
        }
        // Recursive cases
        else if (n == 0) {
            result = acker(m - 1, 1);
        } else {
            result = acker(m - 1, acker(m, n - 1));
        }
        
        // Print the "Leave" message
        printSpaces();
        System.out.println("Leave method acker: acker(" + m + ", " + n + ") = " + result);

        return result;
    }

    // Indent the trace messages according to how "deep" the current recursive call is
    private static void printSpaces(){
        for (int i = 0; i < spaces; i++)
            System.out.print("    "); // 4 spaces for each level
    }

    public static void main(String[] args) {
        // Read two non-negative integers from standard input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input two integers separated by a space character (enter 'q' to quit): ");
        
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int m = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    numberOfInvocations = 0; // Reset the number of invocations
                    int result = acker(m, n);
                    System.out.println("\nTotal number of invocations = " + numberOfInvocations + ", result = " + result);
                } else {
                    System.out.println("Invalid input. Please enter two integers.");
                }
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break; // Exit the program if 'q' is entered
                } else {
                    System.out.println("Invalid input. Please enter two integers.");
                }
            }
            System.out.print("\nInput two integers separated by a space character (enter 'q' to quit): ");
        }
        scanner.close();
    }
}

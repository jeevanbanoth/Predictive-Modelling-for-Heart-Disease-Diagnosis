import java.io.Console;
import java.io.PrintWriter;

public class ChangePassword {
    static boolean validateLogin(String username, String password) {
        return true;
    }

    static boolean resetPassword(String username, String password) {
        return true;
    }

    public static void main(String[] args) {
        Console cons = System.console();

        if (cons == null) {
            System.err.println("No console available.");
            System.exit(1);
        }

        PrintWriter consOutput = cons.writer();
        consOutput.println("Update your password:");

        boolean foundError = false;
        do {
            String pwd = new String(cons.readPassword("       Password:  "));
            String pwd2 = new String(cons.readPassword("Verify password:  "));

            foundError = false;

            if (pwd.length() < 6) {
                consOutput.println("Password must be at least 6 characters long.");
                foundError = true;
                continue; // Skip the remaining checks and start the loop again
            }

            boolean hasDigit = false;
            for (char c : pwd.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                    break;
                }
            }

            if (!pwd.equals(pwd2)) {
                consOutput.println("Passwords do not match. Please try again.");
                foundError = true;
            }

            // If we make it this far, we have passed all of the tests.

        } while (foundError); // This closes the do-while loop properly

        // Password is valid, you can add code here to reset the password if needed.
    }
}

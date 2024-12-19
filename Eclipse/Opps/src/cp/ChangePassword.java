package cp; 
import java.io.Console;
import java.io.PrintWriter;

public class ChangePassword {
    static boolean validateLogin(String username, String password) {
        // Add your login validation logic here.
        return true; // Change this based on your validation
    }

    static boolean resetPassword(String username, String password) {
        // Add your password reset logic here.
        return true; // Change this based on your reset result
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
            } else {
                // Passwords match, so reset the password here.
                String username = "your_username"; // Change this to the actual username
                boolean resetResult = resetPassword(username, pwd);
                if (resetResult) {
                    consOutput.println("Password successfully updated.");
                } else {
                    consOutput.println("Password update failed. Please try again.");
                    foundError = true; // Stay in the loop if the reset operation fails
                }
            }

        } while (foundError); // This closes the do-while loop
    }
}
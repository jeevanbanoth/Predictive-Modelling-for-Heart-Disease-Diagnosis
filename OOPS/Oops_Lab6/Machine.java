package danger;

public class Machine {
    String name;
    Goods g;

    public boolean isDanger(String name) {
        String[] dangerousItems = {"bomb", "poison", "knife", "gun"};
        for (String dangerousItem : dangerousItems) {
            if (name.equals(dangerousItem)) {
                return true;
            }
        }
        return false;
    }

    void checkBag(Goods g) {
        this.g = g;
        name = g.getName();

        // Use a try-catch block to check for dangerous items
        try {
            if (isDanger(name)) {
                // If the item is dangerous, throw a DangerException
                throw new DangerException("Dangerous item detected: " + name);
            }
        } catch (DangerException e) {
            // Handle the exception here (e.g., print a message)
            System.out.println("Security alert: " + e.getMessage());
        } finally {
            // Code to be executed regardless of whether an exception was thrown
            System.out.println("Security check completed.");
        }
    }
}

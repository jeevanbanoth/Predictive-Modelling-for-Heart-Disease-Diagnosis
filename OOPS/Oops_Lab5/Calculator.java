public class Calculator implements Process {

    protected final String[] PROMPT = {
        "In the Input line, please enter the first small Integer\n",
        "In the Input line, please enter the second small Integer"
    };
    protected SmallInt firstSmallInt = new SmallInt();
    protected SmallInt secondSmallInt = new SmallInt();
    protected int step = 0;
    protected GUI gui;

    public Calculator() {
        gui = new GUI(this);
        gui.print(PROMPT[step]);
    }

    public void processInput(String s) {
        if (step == 0) {
            firstSmallInt.setValue(s);
            step++;
            gui.print("You entered the first small integer: " + s + "\n" + PROMPT[step]);
        } else if (step == 1) {
            secondSmallInt.setValue(s);
            int sum = firstSmallInt.add(secondSmallInt);
            gui.println("\nYou entered the second small integer: " + s);
            gui.println("\nThe sum is " + sum);
            gui.freeze();
        }
    }

    public static void main(String argv[]) {
        Calculator calculator = new Calculator();
    }
}

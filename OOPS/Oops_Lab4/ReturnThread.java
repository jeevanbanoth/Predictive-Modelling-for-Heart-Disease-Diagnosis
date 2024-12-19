package Thread;

public class ReturnThread extends Thread {
    ThreadFrame threadFrame;

    public ReturnThread(ThreadFrame threadFrame) {
        this.threadFrame = threadFrame;
    }

    public void run() {
        double result = 0;
        for (int i = 1; i <= 30; i++) {
            // Add code to compute factorial here
            result += computeFactorial(i);

            // Update the GUI with the current result
            threadFrame.resultfield.setText(String.valueOf(result));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("The second thread is wrong");
        }

        threadFrame.button.setText("re-computing");
    }

    // Compute factorial of a number
    private double computeFactorial(int n) {
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

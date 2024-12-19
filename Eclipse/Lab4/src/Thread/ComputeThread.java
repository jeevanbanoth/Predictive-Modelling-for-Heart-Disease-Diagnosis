package Thread;

public class ComputeThread implements Runnable {
    ThreadFrame threadframe;
    static public double result = 0;
    static public int i;
    String str1 = "";

    public ComputeThread(ThreadFrame t) {
        threadframe = t;
    }

    public void run() {
        long s = 1;
        for (i = 1; i <= 30; i++) {
            // Add code to compute factorial here
            s *= i;
            result += s;

            // Update the GUI with the current result
            threadframe.jprogressBar.setValue(i);
            threadframe.resultfield.setText(String.valueOf(result));

            try {
                Thread.sleep((long) (500 + 500 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error in the first thread");
            }
        }
    }
}

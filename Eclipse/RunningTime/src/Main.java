public class Main {
    private static final int CUTOFF = 10; // Adjust the cutoff value as needed

    public static void main(String[] args) {
        // Test your QuickSort implementation here
        Integer[] array = {23,45,67,24,62,49,42,89,34};

        long startTime = System.nanoTime(); // Record start time
        quickSort(array, 0, array.length - 1); // Corrected method name
        long endTime = System.nanoTime(); // Record end time

        long runningTime = endTime - startTime;
        double seconds = (double) runningTime / 1_000_000_000.0; // Convert nanoseconds to seconds

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nRunning Time: " + seconds + " seconds");
    }

    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            AnyType pivot = median3(a, left, right);
            int i = left, j = right - 1;
            while (true) {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[--j].compareTo(pivot) > 0) {}
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        } else {
            insertionSort(a, left, right);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }

        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static <AnyType> void swapReferences(AnyType[] a, int i, int j) {
        AnyType temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a, int left, int right) {
        for (int p = left + 1; p <= right; p++) {
            AnyType tmp = a[p];
            int j;

            for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}

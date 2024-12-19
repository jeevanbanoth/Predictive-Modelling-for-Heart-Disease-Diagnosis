package kSmall;

public class KthSmallest {

    private  static void swap(int[] theArray, int i, int j){
        int temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }

    private static int partition(int[] theArray, int first, int last){
        int p = theArray[first]; // use the first item of the array as the pivot (p)
        int lastS1 = first; // set S1 and S2 to empty

        for (int i = first + 1; i <= last; i++) {
            if (theArray[i] < p) {
                lastS1++;
                swap(theArray, lastS1, i);
            }
        }

        swap(theArray, first, lastS1); // Move the pivot to its correct position
        return lastS1; // the index of the pivot element
    }

    public static int kSmall(int k, int[] anArray, int first, int last) {
        if (k > 0 && k <= last - first + 1) {
            int pivotIndex = partition(anArray, first, last);
            int pivotRank = pivotIndex - first + 1; // Rank of the pivot

            if (k == pivotRank) {
                return anArray[pivotIndex]; // Found the kth smallest element
            } else if (k < pivotRank) {
                return kSmall(k, anArray, first, pivotIndex - 1);
            } else {
                return kSmall(k - pivotRank, anArray, pivotIndex + 1, last);
            }
        }

        return -1; // Dummy return for invalid k
    }
}

public class SortedList implements SortedListInterface {
    private static final int MAX_LIST = 50;
    private Object items[];  // an array of list items
    private int numItems;    // number of items in list

    // default constructor
    public SortedList() {
         items = new Object[MAX_LIST];
         numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int size() {
        return numItems;
    }

    public Object get(int index) throws ListException {

        if (index >= 1 && index <= size()) {
            return items[index-1];
        } else  {  // index out of range
            throw new ListException("get (index out of range): " + index);
        }
    }

    public void removeAll() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    // new operations: sortedAdd
    public void sortedAdd(Comparable newItem) throws ListException {
        if (size() == MAX_LIST)
            throw new ListException("add (array is full)");

        int index = 1;

        while (index <= numItems && newItem.compareTo((Comparable) items[index - 1]) > 0) {
            index++;
        }

        // Shift elements to the right to make space for the new item
        for (int i = numItems; i >= index; i--) {
            items[i] = items[i - 1];
        }

        // Insert the new item at the correct position
        items[index - 1] = newItem;
        numItems++;
    }

    public void sortedRemove(Comparable anItem) throws ListException {
        int index = locateIndex(anItem);

        if (index > numItems || (index <= numItems && anItem.compareTo((Comparable) items[index - 1]) != 0)) {
            throw new ListException("sortedRemove (item not in the list): " + anItem);
        } else {
            // Shift elements to the left to remove the item
            for (int i = index - 1; i < numItems - 1; i++) {
                items[i] = items[i + 1];
            }
            numItems--;
        }
    }


    public int locateIndex(Comparable anItem) {
        int index = 1;

        while (index <= numItems && anItem.compareTo((Comparable) items[index - 1]) > 0) {
            index++;
        }

        if (index <= numItems && anItem.compareTo((Comparable) items[index - 1]) == 0) {
            // Found the item
            return index;
        } else {
            // Item not in the list, return the index where it belongs
            return index;
        }
    }


}
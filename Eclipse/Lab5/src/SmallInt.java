public class SmallInt {
    private int value = 0;

    public int setValue(String s) {
        try {
            int temp = Integer.parseInt(s);
            if (temp >= Integer.MIN_VALUE && temp <= Integer.MAX_VALUE) {
                value = temp;
                return 0;
            } else {
                value = 0;
                return -1;
            }
        } catch (NumberFormatException e) {
            value = 0;
            return -1;
        }
    }

    public int getValue() {
        return value;
    }

    public int add(SmallInt sInt) {
        long sum = (long) this.value + sInt.getValue();
        if(sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
            return (int) sum;
        }
        else {
            return 0;
        }
    }
}

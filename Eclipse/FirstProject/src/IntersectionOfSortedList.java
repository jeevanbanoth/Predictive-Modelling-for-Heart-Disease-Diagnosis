import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedList {
	
	    public static List<Integer> intersection(List<Integer> L1, List<Integer> L2) {
	        List<Integer> intersectionResult = new ArrayList<>();
	        int i = 0, j = 0;

	        while (i < L1.size() && j < L2.size()) {
	            int num1 = L1.get(i), num2 = L2.get(j);
	            if (num1 == num2) intersectionResult.add(num1);
	            if (num1 <= num2) i++;
	            if (num1 >= num2) j++;
	        }
	        return intersectionResult;
	    }
	    public static void main(String[] args) {
	        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
	        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

	        List<Integer> result = intersection(list1, list2);

	        System.out.println("Intersection of L1 and L2: " + result);
	    }
	}




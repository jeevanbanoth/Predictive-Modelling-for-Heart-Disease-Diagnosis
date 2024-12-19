package recursivebs;

public class RecursiveBinarySearch {
	
	public static boolean binarySearch(int[] arr, int low, int high, int target)
	{
		if(low>high)
			return false;
		
		int mid = low + (high-low) / 2;
		
		if(arr[mid] == target) 
			return true;
		else if(arr[mid] > target)
			return binarySearch(arr, low, mid-1, target);
		else
			return binarySearch(arr,mid+1,high,target);
		
	}
	public static void main(String[] args) {
		int[] sortedArray = {2,4,6,8,10,12,14,16,18,20};
		int target = 10;
		
		if(binarySearch(sortedArray,0,sortedArray.length - 1,target)) 
			System.out.println(target + " exists in the array");
		else
			System.out.println(target + " doesn't exists in the given array");
		

	}

}

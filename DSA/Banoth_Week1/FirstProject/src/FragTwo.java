public class FragTwo {

	public static void main(String[] args) {
		   int n = 50;
		    int sum = 0;
		    long startTm = System.nanoTime();
		    int i,j;
		    for(i =0; i<n;i++){
		        {
		            for(j=0;j<i;j++){
		                sum++;
		            }
		        }
		        
		    }
		    long endTime = System.nanoTime();
	        long runT = endTime - startTm;

	        System.out.println("For N = " + n + ":");
	        System.out.println("Sum : "+sum);
	        System.out.println("Running Time: " + (runT / 1e6) + " ms");

	}

}

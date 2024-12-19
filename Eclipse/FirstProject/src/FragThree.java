public class FragThree {
	public static void main(String[] args){
	    int n = 10;
	    int sum = 0;
	    long startTm = System.nanoTime();
	    int i,j,k;
	    for( i = 1; i < n; i++ ){
	        for( j = 1; j < i * i; j++ ){
	              if( j % i == 0 ){
	                          for( k = 0; k < j; k++ ){                        
	                            sum++;
	                          }
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

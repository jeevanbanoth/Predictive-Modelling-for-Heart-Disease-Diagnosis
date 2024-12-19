package multiple_thread_Runnable;

public class Vote implements Runnable{
	private String response;
	
	public Vote(String newResponse) {
		response = newResponse;
	}
	
	public void run() {
		for (int i=0; i<10; i++)
			System.out.println(response);
	}

	public static void main(String[] args) {
		Thread yesThread = new Thread(new Vote("Yes"));
		Thread noThread = new Thread(new Vote("No"));
		
		yesThread.start();
		noThread.start();
		
	}

}

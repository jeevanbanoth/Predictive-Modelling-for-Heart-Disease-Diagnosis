package multiple_thread;

public class Vote extends Thread{
	private String response;
	
	public Vote(String newResponse) {
		response = newResponse;
	}
	
	public void run() {
		for (int i=0; i<10; i++)
			System.out.println(response);
	}

	public static void main(String[] args) {
		
		Vote Yes =  new Vote("yes");
		Vote No = new Vote("no");
		
		Yes.start();
		No.start();
	}

}

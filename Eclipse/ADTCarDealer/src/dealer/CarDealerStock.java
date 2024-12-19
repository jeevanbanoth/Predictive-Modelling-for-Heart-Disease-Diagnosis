package dealer;

public class CarDealerStock {
	private static final int MAX_SIZE = 100;  //Maximum stock size of car dealer, if it gets excess then gets problem for storage(Parking)
	private Car[] cars;  //Array to store cars
	private int size; //Number of cars currently in stock
	
	private class Car{ //inner or nested class
		String make,model;
		int year;
		
		//Constructor
		private Car(String make, String model, int year){ 
			this.make = make;
			this.model = model;
			this.year = year;
		}
		//Other operations such as accelerate, stopebrake, change transmission
		
	}
	//Constructor for CarDealerStock class
	public CarDealerStock() {
		cars = new Car[MAX_SIZE]; //parking lot containing 100 cars
		size = 0;
	}
	//Method (Operation) to create an empty list (reset the stock)
	public void CreateEmptyList() {
		cars = new Car[MAX_SIZE];
		size = 0;
	}
	
	public static void main(String[] args) {
		CarDealerStock stock = new CarDealerStock();
		
		
	}

}
package mycar;
// Class held on sept 12th
class car{
	private String brand; //member variable
	private String model; //member variable
	
	//constructor : special member function of a class
	public car(String brand, String model) {
		this.brand = brand;
		this.model = model;
		
	}
	public void start() {
		System.out.println("Start the" +brand+" "+model);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(4+3*11/2.0-(-2));
		/*int numberOfCars = 10;
		if (numberOfCars == 100) {
			System.out.printf("There are %d cars",numberOfCars);
	}
		else {
			System.out.printf("The car count doesn't match with %d",numberOfCars);
		}*/
		
		/*car myCar = new car("Honda","Civic");
		car myFathercar = new car("Mustang","GT");
		car myMomcar = new car("Toyota","Supraaaaa");*/
		Toyota toyotaSupra = new Toyota ("Toyota","Supra");
		toyotaSupra.Carstart();
		toyotaSupra.accelerate();
		
		
	}
	
}

package danger;

import java.util.Scanner;
public class Test {
	 public static void main(String[] args) {
	        
	        while(true) {
	            Scanner sc=new Scanner(System.in);
	            
	            System.out.println("Please input items:");
	            String input=sc.nextLine();
	            Goods g=new Goods();
	            g.setName(input);
	            Machine m=new Machine();
	            m.checkBag(g);
	        
	        }
	    }

}

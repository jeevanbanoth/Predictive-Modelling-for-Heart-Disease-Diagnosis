public class WordTransformer {
	    public static void main(String[] args) {
	        String inString0 = "Gilligan";
	        String inString1 = "Hello everyone!";
	        String inString2 = "My mother says the weather is poor there.";

	        String[] words2 = inString2.split(" ");
	        String firstWord2 = words2[words2.length - 2];
	        String lastWord2 = words2[words2.length - 1];

	        String capitalizedInString0 = inString0.substring(0, 1).toUpperCase() + inString0.substring(1);

	        String[] words1 = inString1.split(" ");
	        String helloFromInString1 = "";
	        for (String word : words1) {
	            if (word.equalsIgnoreCase("hello")) {
	                helloFromInString1 = "hello";
	                break;
	            }
	        }

	        lastWord2 = lastWord2.replaceAll("[^a-zA-Z]", "");

	        String output = firstWord2 + " " + capitalizedInString0 + " says " + helloFromInString1 + " " + lastWord2 + "!";

	        output = output.substring(0, 1).toUpperCase() + output.substring(1);

	        System.out.println(output);
	    }
	}


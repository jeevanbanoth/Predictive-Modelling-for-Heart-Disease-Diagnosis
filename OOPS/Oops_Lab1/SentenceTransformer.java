public class SentenceTransformer {
    public static void main(String[] args) {
        String inString0 = "Let's ask that dude Fred.";
        String inString1 = "Who said it is my turn to look for one?"; 
        String inString2 = "Take the computer from Janet!"; 

        String[] words2 = inString2.split(" ");
        String firstWord2 = words2[words2.length - 1];

        String capitalizedInString0 = inString0.substring(0, 1).toUpperCase() + inString0.substring(1);

        String[] words1 = inString0.split(" ");
        String lastWord0 = "dude";
        
        for (String word : words1) {
            if (word.equalsIgnoreCase("dude")) {
                lastWord0 = "dude";
                break;
            }
        }
		String sentence = inString1;
		String[] words = sentence.split(" ");
		String extractedWord = words[1];
        
        String sentence2 = inString0;
		String[] name = sentence2.split(" ");
		String extractedname = name[4];
        String removedname = extractedname.substring(0, extractedname.length() - 1);

        String sentence3 = inString1;
		String[] fillsentence = sentence3.split(" ");
		String extractedsentence = fillsentence[3]+" "+fillsentence[9];
        String removedsentence = extractedsentence.substring(0, extractedsentence.length() - 1);

        firstWord2 = firstWord2.replaceAll("[^a-zA-Z]", "");

        String output = firstWord2 + " " + extractedWord+" " +removedname+" "+removedsentence+" "+"kool"+" "+lastWord0 + "!";

        System.out.println(output);
    }
}
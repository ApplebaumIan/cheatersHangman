package cheatersHangman;
/***********************
Jonathan and Ian's Cheaters hangman main code
***********************/
import java.util.*;
import java.lang.*;
public class Hangman {
 //stores the words in an ArrayList. The ReplaceAll method replaces commas, punctuations, etc. 
    public static List<String> readFile(String filename) {
        String line;
        String[] word;
        List<String> words = new ArrayList<String>();
        List<Integer> lineNum = new ArrayList<Integer>();
        int i = 1;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                word = line.split("\\s+");
                //for each string in word, do this
                for (String singleword : word) {
                    singleword = singleword.replaceAll("[^a-zA-Z'\\s]", "").replaceAll("(\r?\n){2}", "§").replaceAll("[\t\r\n]+", " ").replace("§", "\n");          //removes punctuations except hyphens and apostrophes
                    //System.out.println(singleword);
                    words.add(singleword);
                    lineNum.add(i);
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }
       
	//MAIN METHOD
	public static void main(String[] args) {
		System.out.println("Hello World and Jon");
		//Short Attempt to get file reading working on the train home... so far no success
		System.out.println(readFile("dictionary.txt"));
		
	// TODO Auto-generated method stub
		//YEET
	}
    //hello!!!
    //that's all we really need to do today
    //might make a very rough outline though
    //You can get back to packing and stuff
    //I'll probably get us started later tonight
    //Good luck and have fun

    //True, I won't be at this computer tomorrow.
}

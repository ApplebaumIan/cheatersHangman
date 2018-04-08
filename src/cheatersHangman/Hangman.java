package cheatershangman;
import java.io.File;
import java.util.*;
import java.lang.*;

public class CheatersHangman {

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
       
	//MAIN METHOD
    public static void main(String[] args) {
	List<String> dictionary = readFile("dictionary.txt");
        List<String> words;
        int wordLength = 0;
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while(!done) {
            System.out.print("Choose the length of the word you want to guess: ");
            wordLength = in.nextInt();
            words = new ArrayList();
            for(String word : dictionary) {
                if(word.length() == wordLength) {
                    words.add(word);
                }
            }
            if(words.size() == 0) {
                System.out.println("There are no words with that length. Pick a different length.\n");
            }
            else {
                done = true;
            }
        }
        System.out.print("Choose the amount of incorrect guesses it will take for you to lose: ");
        int guesses = in.nextInt();
        if(guesses < 1) {
            guesses = 1;
        }
        else if(guesses > 26) {
            guesses = 26;
        }
        String hiddenWord = "";
        for(int i = 0; i < wordLength; i++) {
            hiddenWord += "_";
        }
        while(guesses != 0 && hiddenWord.contains("_")) {
            System.out.print("Guess a letter: ");
        }
    }
    
}

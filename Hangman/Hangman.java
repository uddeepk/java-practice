import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
	public static void main(String[] args) {
		String [] words = {"write" , "that" , "program"};
		
		Scanner input = new Scanner(System.in);
		
		boolean [] matchLetter ;
		
		String word;
		
		
			
		char userInput ;
		int misses;
		do {
		
			word = words[(int)(Math.random()*words.length)];
			matchLetter = new boolean [word.length()];
			Arrays.fill ( matchLetter , false);
			userInput = '\u0000';
			misses = 0;
			
			while( !(isWord(matchLetter))) {
				
				System.out.print("(Guess) Enter a letter in word " 
				+ getWord(word , matchLetter) + " > ");
				
				userInput = input.nextLine().charAt(0);
				
				if(isAlreadyInWord(word, userInput , matchLetter)) {
					System.out.println(userInput + " is already in word.");
				}
				else if(!isInWord(word, userInput, matchLetter)){
					misses++;
					System.out.println(userInput + " is not in the word.");
				}	 
			}
			System.out.println("The word is " + word + ". You missed " + misses + " times.");
			System.out.print("Do you want to guess another word? Enter y or n> ");
			userInput = input.nextLine().charAt(0);
		} while (Character.toLowerCase(userInput)=='y');
	}
	public static boolean isWord(boolean [] a) {
		for(int i = 0 ; i < a.length ; i++) {
			if( !(a[i])) {
				return false;
			}
		}
		return true;
	}
	public static String getWord(String word, boolean [] matchLetter) {
		String result="";
		for(int i = 0 ; i<word.length() ; i++) {
			result = result + ((matchLetter[i]) ? word.charAt(i) : "*"); 
		}
		return result;
	}
	public static boolean isAlreadyInWord( String word, char userInput , boolean [] 			matchLetter)  {
		for(int i = 0 ; i < word.length() ; i++) {
			if((matchLetter[i] && ( word.charAt(i)==userInput))) {
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean isInWord( String word, char userInput , boolean [] matchLetter) {
		int counter = 0;
		for(int i = 0 ; i< word.length() ; i ++) {
			if((matchLetter[i]!=true) && (word.charAt(i)==userInput)) {
				matchLetter[i] = true;
				counter++;
			}
		}
		return(counter>0);
	}
}

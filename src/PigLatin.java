import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		String word = null;
		String keepPlaying = null;
		Scanner scan = new Scanner(System.in);

		// greeting
		System.out.println("Welcome to the Pig Latin Translator!" + "\n");

		// prompt to run once + keep playing?
		do {
			System.out.print("Enter a word to be translated: ");
			word = scan.next();
			System.out.println(translatePigLatin(word));
			System.out.print("Translate another word? (y/n) ");
			keepPlaying = scan.next();
		} while (keepPlaying.toLowerCase().contains("y"));

		scan.close();

	}

	// this method translates
	public static String translatePigLatin(String word) {
		if (startsWithVowel(word) == true) {
			return word.concat("way").toLowerCase();
		} else {
			return startsWithConsonant(word);
		}
	
	}

	// if starts w/ consonant, loops front letter to back until vowel
	public static String startsWithConsonant(String word) {

		// while loop finds all consonants before vowel
		while (startsWithVowel(word) != true) {

			// takes consonant(s) before vowel and adds to back
			char letter = word.charAt(0);
			String letterString = Character.toString(letter);
			word = word.substring(1).concat(letterString);
		}

		return word.concat("ay").toLowerCase();
	}

	// list of vowels
	public static boolean startsWithVowel(String word) {
		char firstLetter = word.charAt(0);

		switch (firstLetter) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			return true;
		default:
			return false;
		}

	}

}
/**
 * 
 */
package com.EncryptionMachine;
import java.util.Scanner; 

/**
 * @author a.lamichhane
 *
 */
public class EncryptionMachine {

	/**
	 * @param args
	 */
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static int SHIFT = 3;

	/**
	 * Prints the Welcome Message when the application is run. 
	 * @param do not take any parameters
	 * @return do not return it's a void method
	*/
	public void printWelcomeMessage() {
		
		System.out.println("Welcome to CSCI717 Encryption Machine Construction\n"
						   + "The program lets you encrypt a message\n"
		                   + "with a key for your recipient to decrypt!");
		System.out.println(System.lineSeparator());
			
	}

	/**
	 * Prints exit message once all words are encrypted for user
	 * @param do not take any parameters
	 * @return do not return it's a void method
	*/
	public void printExitMessage() {
		System.out.println("\nMessage fully encrypted. Happy secret messaging!");
	}

	/**
	 * Prompts the user regarding how many words user wants to encrypt
	 * @param do not take any parameters
	 * @return returns the int receive from user (how many words user wants to encrypt)
	*/
	private int numberOfwords() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("\nHow many words in your message?:");
		
		int numOfWords = myObj.nextInt();
		return numOfWords;
	
	}

	/**
	 * Encrypts the character using SHIFT constant and returns encrypted
	 * character. for example if character
	 * is b and SHIFT is 2 encrypted character will be d
	 * @param takes a character all lower case a-z
	 * @return the encrypted character
	*/
	private char encryptChar(char a) {
		if (ALPHABET.indexOf(a) == -1) {
			System.out.println("Invalid Alphabet has been used, Terminating now!");
			System.exit(1);
			
		} 
		char origChar = a;
		int origCharAscii = (int) origChar; //calculating ascii value of char
		int charIndex = (origCharAscii - 97); //Subtracting ascii value of a
		int newCharIndex = (charIndex + SHIFT)%26; //wrapping by 26 
		int newAscii = newCharIndex + 97; // calculating new ascii value 
		char convertedChar = (char) newAscii; // calculating char of new ascii value
		return convertedChar;

	}
	
	/**
	* Code review comment: Missing code to convert uppercase 
*alphabets to lowercase. We can always use function 
*toLowerCase() to do that.
*/

	
	/**
	 * Encrypts a word using SHIFT constant and returns encrypted
	 * word. for example if a word is cat and 
	 * SHIFT is 1 encrypted word will be dbu
	 * @param takes a word all lower case a-z
	 * @return the encrypted word
	*/
	private String encryptWord(String word) {
		String encryptWord = "";		
		for(int i = 0;i<word.length();i++) {
			char convertedChar = encryptChar(word.charAt(i));
			encryptWord +=convertedChar;
		} 
		return encryptWord;	
		
	}

	/**
	 * Exchange the encryption key to the user, prompts the user to enter key
	 * and returns the encrypted key. if abc is entered by user and SHIFT is 2
	 * cde will ve printed out as encrypted. 
	 * @param do not take parameter
	 * @return do not return.  
	*/
	public void exchangeKey() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter key:");		
		String key = myObj.nextLine();
		System.out.println('\u0022'+ key +'\u0022'+ " has been encrypted to: " + 
								encryptWord(key)+"\n");
		
	}

	/**
	 * Encrypt the word entered by the user, prompts the user to enter how many
	 * words user wants to encrypt and prompts the user to enter word and encrypts 
	 * the user word and prints for the user.
	 * @param do not take parameter
	 * @return do not return.  
	*/
	/**
	*Code review comments: Really good explanation
	*/ 
	public void encryptUserData() {
		Scanner myObj = new Scanner(System.in);
		int numOfWordsToEncrypt = numberOfwords();
		for (int i = 1;i<=numOfWordsToEncrypt;i++) {
			System.out.println("Next word:");
			String origWord = myObj.nextLine();
			System.out.println('\u0022'+ origWord +'\u0022' + " has been encrypted to: " + 
								encryptWord(origWord)+"\n");
			
		}
		
	}
	
	/**
	*Code review comments: Code for decryption is missing
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncryptionMachine em = new EncryptionMachine();
		em.printWelcomeMessage();
		em.exchangeKey();
		em.encryptUserData();
		em.printExitMessage();
	}

}

import java.util.Scanner;
public class EncryptionMachine {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
      /**
     * Encrypting string using ciphertext.
     * It takes all lowercase words.
     * In the logic, we are shifting the position of every alphabet by +1.
     */
 
    public static String encrypt(String plainText, int shiftKey)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
    
     /**
     * Decrypting string using ciphertext.
     * It takes all lowercase words.
     * In the logic, we are shifting the position of every alphabet by -1.
     */
    
    
    public static String decrypt(String cipherText, int shiftKey)
    {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }

 /**
     * User will enter the string he/she want to encrypt and then decrypt.
     */

public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String for Encryption: ");
    String message = new String();
    message = sc.next();
    System.out.println("String after Enryption is as following: ");
    System.out.println(encrypt(message, 3));
    System.out.println("String after Decryption is as following: ");
    System.out.println(decrypt(encrypt(message, 3), 3));
    sc.close();
}
}

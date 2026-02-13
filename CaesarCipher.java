import java.util.Scanner;

public class CaesarCipher {

    // Encrypt text using Caesar Cipher
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encrypted.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                encrypted.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // Decrypt text using Caesar Cipher
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    // Display ASCII values before and after encryption
    public static void displayAscii(String original, String encrypted) {
        System.out.println("\nCharacter | Original ASCII | Encrypted ASCII");
        for (int i = 0; i < original.length(); i++) {
            System.out.printf("   %c      |      %d        |       %d%n",
                    original.charAt(i), (int) original.charAt(i), (int) encrypted.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        displayAscii(text, encrypted);

        if (text.equals(decrypted)) {
            System.out.println("\nDecryption successful ✅");
        } else {
            System.out.println("\nDecryption failed ❌");
        }

        sc.close();
    }
}

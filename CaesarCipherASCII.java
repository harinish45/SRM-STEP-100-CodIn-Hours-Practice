import java.util.Scanner;

public class CaesarCipherASCII {

    // Encrypt method
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Wrap-around A-Z
                char newChar = (char) ((c - 'A' + shift) % 26 + 'A');
                encrypted.append(newChar);
            } else if (Character.isLowerCase(c)) {
                // Wrap-around a-z
                char newChar = (char) ((c - 'a' + shift) % 26 + 'a');
                encrypted.append(newChar);
            } else {
                // Non-alphabetic unchanged
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        // Just reverse the shift
        return encrypt(text, 26 - (shift % 26));
    }

    // Display ASCII values before and after encryption
    public static void displayAsciiValues(String original, String encrypted) {
        System.out.println("\nASCII Values:");
        System.out.println("-------------------------------------");
        System.out.printf("%-15s %-15s %-15s%n", "Original", "Encrypted", "ASCII(Encrypted)");
        System.out.println("-------------------------------------");

        for (int i = 0; i < original.length(); i++) {
            char o = original.charAt(i);
            char e = encrypted.charAt(i);
            System.out.printf("%-15s %-15s %-15d%n", o + " (" + (int) o + ")", e, (int) e);
        }
        System.out.println("-------------------------------------");
    }

    // Validation
    public static void validate(String original, String decrypted) {
        if (original.equals(decrypted)) {
            System.out.println("\nValidation: SUCCESS ✅ (Decryption matches original text)");
        } else {
            System.out.println("\nValidation: FAILED ❌ (Mismatch found)");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String text = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        // Encrypt
        String encrypted = encrypt(text, shift);
        // Decrypt
        String decrypted = decrypt(encrypted, shift);

        // Display results
        System.out.println("\nOriginal Text: " + text);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        displayAsciiValues(text, encrypted);
        validate(text, decrypted);

        sc.close();
    }
}

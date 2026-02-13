import java.util.*;

public class PasswordAnalyzer {

    // Analyze password
    public static int analyzePassword(String pwd) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        for (char c : pwd.toCharArray()) {
            if (c >= 65 && c <= 90) upper++;
            else if (c >= 97 && c <= 122) lower++;
            else if (c >= 48 && c <= 57) digits++;
            else special++;
        }

        int score = 0;
        if (pwd.length() > 8) score += (pwd.length() - 8) * 2;
        if (upper > 0) score += 10;
        if (lower > 0) score += 10;
        if (digits > 0) score += 10;
        if (special > 0) score += 10;

        if (pwd.toLowerCase().contains("123") || pwd.toLowerCase().contains("abc") || pwd.toLowerCase().contains("qwerty"))
            score -= 15;

        return Math.max(score, 0);
    }

    // Strength Level
    public static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    // Password generator
    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!@#$%^&*";

        String all = upper + lower + digits + specials;
        StringBuilder sb = new StringBuilder();

        Random r = new Random();
        sb.append(upper.charAt(r.nextInt(upper.length())));
        sb.append(lower.charAt(r.nextInt(lower.length())));
        sb.append(digits.charAt(r.nextInt(digits.length())));
        sb.append(specials.charAt(r.nextInt(specials.length())));

        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(r.nextInt(all.length())));
        }

        List<Character> chars = new ArrayList<>();
        for (char c : sb.toString().toCharArray()) chars.add(c);
        Collections.shuffle(chars);

        StringBuilder shuffled = new StringBuilder();
        for (char c : chars) shuffled.append(c);

        return shuffled.toString();
    }

    public static void displayResults(List<String> passwords) {
        System.out.println("\nPassword Strength Report:");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s%n", "Password", "Score", "Strength");
        System.out.println("-------------------------------------------------------------------");
        for (String pwd : passwords) {
            int score = analyzePassword(pwd);
            System.out.printf("%-20s %-10d %-10s%n", pwd, score, strengthLevel(score));
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> passwords = new ArrayList<>();
        System.out.print("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords.add(sc.nextLine());
        }

        displayResults(passwords);

        System.out.print("\nGenerate strong password of length: ");
        int len = sc.nextInt();
        System.out.println("Generated Password: " + generatePassword(len));

        sc.close();
    }
}

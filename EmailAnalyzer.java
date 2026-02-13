import java.util.*;

public class EmailAnalyzer {

    // Validate email format
    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dotIndex = email.lastIndexOf('.');

        return atIndex > 0 && atIndex == lastAt && dotIndex > atIndex && dotIndex < email.length() - 1;
    }

    // Extract components
    public static Map<String, String> extractComponents(String email) {
        Map<String, String> parts = new HashMap<>();
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        parts.put("username", email.substring(0, atIndex));
        parts.put("domain", email.substring(atIndex + 1));
        parts.put("domainName", email.substring(atIndex + 1, dotIndex));
        parts.put("extension", email.substring(dotIndex + 1));
        return parts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();

        System.out.print("Enter number of emails: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            emails.add(sc.nextLine());
        }

        int validCount = 0, invalidCount = 0;
        Map<String, Integer> domainFrequency = new HashMap<>();
        int totalUsernameLength = 0;

        System.out.println("\nEmail Analysis Report:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Email\t\tUsername\tDomain\tDomainName\tExt\tValid?");
        System.out.println("--------------------------------------------------------------");

        for (String email : emails) {
            if (isValidEmail(email)) {
                validCount++;
                Map<String, String> parts = extractComponents(email);
                totalUsernameLength += parts.get("username").length();

                domainFrequency.put(parts.get("domain"),
                        domainFrequency.getOrDefault(parts.get("domain"), 0) + 1);

                System.out.printf("%s\t%s\t\t%s\t%s\t\t%s\tVALID%n",
                        email, parts.get("username"), parts.get("domain"),
                        parts.get("domainName"), parts.get("extension"));
            } else {
                invalidCount++;
                System.out.printf("%s\t---\t\t---\t---\t\t---\tINVALID%n", email);
            }
        }

        // Most common domain
        String mostCommonDomain = domainFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        double avgUsernameLength = validCount > 0 ? (double) totalUsernameLength / validCount : 0;

        System.out.println("\nSummary:");
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + mostCommonDomain);
        System.out.printf("Average Username Length: %.2f%n", avgUsernameLength);

        sc.close();
    }
}

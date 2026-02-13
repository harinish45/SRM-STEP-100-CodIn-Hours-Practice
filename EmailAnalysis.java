import java.util.*;

public class EmailAnalysis {

    // Method to validate email
    public static boolean validateEmail(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        int dotPos = email.lastIndexOf('.');

        // Check: exactly one '@', at least one '.' after '@', and valid positions
        if (atPos > 0 && atPos == lastAtPos && dotPos > atPos + 1 && dotPos < email.length() - 1) {
            return true;
        }
        return false;
    }

    // Extract components
    public static Map<String, String> extractComponents(String email) {
        Map<String, String> components = new HashMap<>();
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');

        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);
        String domainName = email.substring(atPos + 1, dotPos);
        String extension = email.substring(dotPos + 1);

        components.put("username", username);
        components.put("domain", domain);
        components.put("domainName", domainName);
        components.put("extension", extension);

        return components;
    }

    // Analyze statistics
    public static void analyzeStatistics(List<String> emails, List<Boolean> validity, List<Map<String, String>> details) {
        int validCount = 0, invalidCount = 0;
        int totalUsernameLength = 0;
        Map<String, Integer> domainFrequency = new HashMap<>();

        for (int i = 0; i < emails.size(); i++) {
            if (validity.get(i)) {
                validCount++;
                String domain = details.get(i).get("domain");
                totalUsernameLength += details.get(i).get("username").length();

                domainFrequency.put(domain, domainFrequency.getOrDefault(domain, 0) + 1);
            } else {
                invalidCount++;
            }
        }

        // Find most common domain
        String mostCommonDomain = "-";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : domainFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }

        double avgUsernameLength = validCount > 0 ? (double) totalUsernameLength / validCount : 0;

        System.out.println("\nEmail Statistics:");
        System.out.println("-------------------------------------------------");
        System.out.println("Total Emails        : " + emails.size());
        System.out.println("Valid Emails        : " + validCount);
        System.out.println("Invalid Emails      : " + invalidCount);
        System.out.println("Most Common Domain  : " + mostCommonDomain);
        System.out.println("Avg Username Length : " + String.format("%.2f", avgUsernameLength));
        System.out.println("-------------------------------------------------");
    }

    // Display table
    public static void displayResults(List<String> emails, List<Boolean> validity, List<Map<String, String>> details) {
        System.out.println("\nEmail Analysis Results:");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-15s %-25s %-15s %-15s %-10s%n", "Email", "Username", "Domain", "Domain Name", "Extension", "Valid?");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < emails.size(); i++) {
            String email = emails.get(i);
            if (validity.get(i)) {
                Map<String, String> comp = details.get(i);
                System.out.printf("%-30s %-15s %-25s %-15s %-15s %-10s%n",
                        email,
                        comp.get("username"),
                        comp.get("domain"),
                        comp.get("domainName"),
                        comp.get("extension"),
                        "Yes");
            } else {
                System.out.printf("%-30s %-15s %-25s %-15s %-15s %-10s%n",
                        email, "-", "-", "-", "-", "No");
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> emails = new ArrayList<>();
        List<Boolean> validity = new ArrayList<>();
        List<Map<String, String>> details = new ArrayList<>();

        System.out.print("Enter number of emails: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            String email = sc.nextLine();
            emails.add(email);

            boolean isValid = validateEmail(email);
            validity.add(isValid);

            if (isValid) {
                details.add(extractComponents(email));
            } else {
                details.add(new HashMap<>());
            }
        }

        // Display results
        displayResults(emails, validity, details);

        // Analyze statistics
        analyzeStatistics(emails, validity, details);

        sc.close();
    }
}

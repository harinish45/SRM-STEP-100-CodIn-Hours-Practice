import java.util.*;

public class SpellChecker {

    // Split sentence into words without split()
    public static List<String> extractWords(String sentence) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                if (i > start) words.add(sentence.substring(start, i));
                start = i + 1;
            }
        }
        if (start < sentence.length()) words.add(sentence.substring(start));
        return words;
    }

    // String distance (simple)
    public static int stringDistance(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int diff = Math.abs(lenA - lenB);
        int minLen = Math.min(lenA, lenB);
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    // Suggest closest match
    public static String suggestWord(String word, String[] dict) {
        String best = word;
        int minDist = Integer.MAX_VALUE;
        for (String d : dict) {
            int dist = stringDistance(word.toLowerCase(), d.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                best = d;
            }
        }
        return (minDist <= 2) ? best : word;
    }

    // Display results
    public static void displayResults(List<String> words, String[] dict) {
        System.out.println("\nSpell Check Report:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s%n", "Word", "Suggestion", "Status");
        System.out.println("---------------------------------------------------------");
        for (String w : words) {
            String sug = suggestWord(w, dict);
            if (sug.equalsIgnoreCase(w)) {
                System.out.printf("%-15s %-15s %-15s%n", w, "-", "Correct");
            } else {
                System.out.printf("%-15s %-15s %-15s%n", w, sug, "Misspelled");
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"hello", "world", "java", "programming", "string", "spell", "checker"};

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        List<String> words = extractWords(sentence);
        displayResults(words, dictionary);

        sc.close();
    }
}

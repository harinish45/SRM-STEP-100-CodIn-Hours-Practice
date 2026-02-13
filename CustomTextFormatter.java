import java.util.*;

public class CustomTextFormatter {

    // Split words without using split()
    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start != i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words.add(text.substring(start));
        }
        return words;
    }

    // Justify text
    public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int count = 0;

        for (String word : words) {
            if (count + word.length() + line.length() > width) {
                distributeSpaces(line, width);
                lines.add(line.toString());
                line = new StringBuilder(word);
                count = word.length();
            } else {
                if (line.length() > 0) line.append(" ");
                line.append(word);
                count += word.length();
            }
        }
        lines.add(line.toString()); // last line left aligned
        return lines;
    }

    // Distribute spaces
    private static void distributeSpaces(StringBuilder line, int width) {
        int extraSpaces = width - line.length();
        int gaps = (int) line.chars().filter(c -> c == ' ').count();
        if (gaps == 0) return;

        int i = 0;
        while (extraSpaces > 0) {
            if (line.charAt(i) == ' ') {
                line.insert(i, ' ');
                i++;
                extraSpaces--;
            }
            i++;
            if (i >= line.length()) i = 0;
        }
    }

    // Center align
    public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int count = 0;

        for (String word : words) {
            if (count + word.length() + line.length() > width) {
                int padding = (width - line.length()) / 2;
                StringBuilder centered = new StringBuilder(" ".repeat(padding)).append(line);
                lines.add(centered.toString());
                line = new StringBuilder(word);
                count = word.length();
            } else {
                if (line.length() > 0) line.append(" ");
                line.append(word);
                count += word.length();
            }
        }
        lines.add(line.toString());
        return lines;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        List<String> words = splitWords(text);

        long start1 = System.nanoTime();
        List<String> justified = justifyText(words, width);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        List<String> centered = centerAlign(words, width);
        long end2 = System.nanoTime();

        System.out.println("\nOriginal Text:\n" + text);
        System.out.println("\nLeft-Justified Text:");
        int lineNum = 1;
        for (String line : justified) {
            System.out.printf("%2d | %-"+width+"s | Length: %d%n", lineNum++, line, line.length());
        }

        System.out.println("\nCenter-Aligned Text:");
        lineNum = 1;
        for (String line : centered) {
            System.out.printf("%2d | %-"+width+"s | Length: %d%n", lineNum++, line, line.length());
        }

        System.out.println("\nPerformance Comparison:");
        System.out.println("Justify using StringBuilder: " + (end1 - start1) + " ns");
        System.out.println("Center align using StringBuilder: " + (end2 - start2) + " ns");

        sc.close();
    }
}

import java.util.*;

public class TextFormatter {

    // Method to split words without split()
    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
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

    // Justify text using StringBuilder
    public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        List<String> currentLineWords = new ArrayList<>();

        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() + currentLineWords.size() <= width) {
                currentLineWords.add(word);
                lineLength += word.length();
            } else {
                // Distribute spaces
                int totalSpaces = width - lineLength;
                int gaps = currentLineWords.size() - 1;
                StringBuilder justified = new StringBuilder();

                if (gaps > 0) {
                    int spacePerGap = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;

                    for (int i = 0; i < currentLineWords.size(); i++) {
                        justified.append(currentLineWords.get(i));
                        if (i < gaps) {
                            for (int s = 0; s < spacePerGap; s++) justified.append(" ");
                            if (extraSpaces > 0) {
                                justified.append(" ");
                                extraSpaces--;
                            }
                        }
                    }
                } else {
                    justified.append(currentLineWords.get(0));
                    while (justified.length() < width) justified.append(" ");
                }

                lines.add(justified.toString());
                currentLineWords.clear();
                currentLineWords.add(word);
                lineLength = word.length();
            }
        }

        // Last line (left aligned)
        line.setLength(0);
        for (int i = 0; i < currentLineWords.size(); i++) {
            line.append(currentLineWords.get(i));
            if (i < currentLineWords.size() - 1) line.append(" ");
        }
        while (line.length() < width) line.append(" ");
        lines.add(line.toString());

        return lines;
    }

    // Center align text
    public static List<String> centerText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + (lineLength > 0 ? 1 : 0) <= width) {
                if (lineLength > 0) {
                    line.append(" ");
                    lineLength++;
                }
                line.append(word);
                lineLength += word.length();
            } else {
                int padding = (width - lineLength) / 2;
                StringBuilder centered = new StringBuilder();
                for (int i = 0; i < padding; i++) centered.append(" ");
                centered.append(line);
                while (centered.length() < width) centered.append(" ");
                lines.add(centered.toString());

                line.setLength(0);
                line.append(word);
                lineLength = word.length();
            }
        }

        // Last line
        int padding = (width - lineLength) / 2;
        StringBuilder centered = new StringBuilder();
        for (int i = 0; i < padding; i++) centered.append(" ");
        centered.append(line);
        while (centered.length() < width) centered.append(" ");
        lines.add(centered.toString());

        return lines;
    }

    // Performance comparison
    public static void performanceTest(List<String> words, int width) {
        long startSB = System.nanoTime();
        justifyText(words, width);
        long endSB = System.nanoTime();

        long startConcat = System.nanoTime();
        // Same logic but with String concatenation (inefficient)
        String result = "";
        for (String word : words) {
            result = result + word + " ";
        }
        long endConcat = System.nanoTime();

        System.out.println("\nPerformance Comparison:");
        System.out.println("----------------------------------");
        System.out.println("Using StringBuilder : " + (endSB - startSB) + " ns");
        System.out.println("Using String (+)    : " + (endConcat - startConcat) + " ns");
        System.out.println("----------------------------------");
    }

    // Display formatted text
    public static void displayFormatted(List<String> lines, String title) {
        System.out.println("\n" + title);
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("Line %2d (%2d chars): %s%n", i + 1, lines.get(i).length(), lines.get(i));
        }
        System.out.println("-----------------------------------------------------");
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = sc.nextLine();

        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        List<String> words = getWords(text);

        List<String> justified = justifyText(words, width);
        List<String> centered = centerText(words, width);

        // Display outputs
        System.out.println("\nOriginal Text:\n" + text);
        displayFormatted(justified, "Justified Text");
        displayFormatted(centered, "Center-Aligned Text");

        // Performance
        performanceTest(words, width);

        sc.close();
    }
}

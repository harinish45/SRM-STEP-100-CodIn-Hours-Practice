import java.util.*;

public class TextCompressor {

    // Count frequency
    public static void countFrequency(String text, List<Character> chars, List<Integer> freq) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int idx = chars.indexOf(c);
            if (idx == -1) {
                chars.add(c);
                freq.add(1);
            } else {
                freq.set(idx, freq.get(idx) + 1);
            }
        }
    }

    // Build code mapping
    public static Map<Character, String> buildCodes(List<Character> chars, List<Integer> freq) {
        Map<Character, String> codes = new HashMap<>();
        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            if (freq.get(i) > 5) codes.put(c, String.valueOf(i));
            else codes.put(c, "#" + i);
        }
        return codes;
    }

    // Compress
    public static String compress(String text, Map<Character, String> codes) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(codes.get(c));
        return sb.toString();
    }

    // Decompress
    public static String decompress(String compressed, Map<Character, String> codes) {
        Map<String, Character> reverse = new HashMap<>();
        for (Map.Entry<Character, String> e : codes.entrySet()) {
            reverse.put(e.getValue(), e.getKey());
        }

        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (int i = 0; i < compressed.length(); i++) {
            temp += compressed.charAt(i);
            if (reverse.containsKey(temp)) {
                sb.append(reverse.get(temp));
                temp = "";
            }
        }
        return sb.toString();
    }

    public static void displayAnalysis(String text, String compressed, String decompressed, List<Character> chars, List<Integer> freq, Map<Character, String> codes) {
        System.out.println("\nCompression Analysis:");
        System.out.println("---------------------------------------------------");
        System.out.println("Original:   " + text);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);
        System.out.println("Compression Ratio: " + (100.0 * compressed.length() / text.length()) + "%");
        System.out.println("\nCharacter Mapping:");
        for (int i = 0; i < chars.size(); i++) {
            System.out.println(chars.get(i) + " -> " + codes.get(chars.get(i)) + " (" + freq.get(i) + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();

        List<Character> chars = new ArrayList<>();
        List<Integer> freq = new ArrayList<>();
        countFrequency(text, chars, freq);

        Map<Character, String> codes = buildCodes(chars, freq);
        String compressed = compress(text, codes);
        String decompressed = decompress(compressed, codes);

        displayAnalysis(text, compressed, decompressed, chars, freq, codes);

        sc.close();
    }
}

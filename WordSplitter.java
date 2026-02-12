import java.util.Scanner;

public class WordSplitter {
    public static String[] customSplit(String text) {
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ') spaceCount++;

        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int idx = 1;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ') spaceIndexes[idx++] = i;
        spaceIndexes[idx] = text.length();

        String[] words = new String[spaceIndexes.length - 1];
        for (int i = 0; i < words.length; i++)
            words[i] = text.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]);

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] custom = customSplit(input);
        String[] builtIn = input.split(" ");

        boolean areSame = compareArrays(custom, builtIn);

        System.out.println("Custom Split: ");
        for (String word : custom) System.out.println(word);
        System.out.println("Built-in Split: ");
        for (String word : builtIn) System.out.println(word);

        System.out.println("Are both equal? " + areSame);
    }
}


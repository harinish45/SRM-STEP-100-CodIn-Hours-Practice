import java.util.Scanner;

public class ShortestLongest {
    public static int findLength(String str) {
        int count = 0;
        try { while (true) { str.charAt(count); count++; } }
        catch (Exception e) {}
        return count;
    }

    public static String[] customSplit(String str) {
        int len = findLength(str), spaceCount = 0;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') spaceCount++;
        String[] words = new String[spaceCount + 1];
        int start = 0, idx = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || str.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) sb.append(str.charAt(j));
                words[idx++] = sb.toString();
                start = i + 1;
            }
        }
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] res = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(findLength(words[i]));
        }
        return res;
    }

    public static int[] shortestLongestIndex(String[][] arr) {
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (Integer.parseInt(arr[i][1]) < Integer.parseInt(arr[minIdx][1])) minIdx = i;
            if (Integer.parseInt(arr[i][1]) > Integer.parseInt(arr[maxIdx][1])) maxIdx = i;
        }
        return new int[] {minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[][] data = wordsWithLengths(customSplit(input));
        int[] idx = shortestLongestIndex(data);

        System.out.println("Shortest word: " + data[idx[0]][0]);
        System.out.println("Longest word: " + data[idx[1]][0]);
    }
}

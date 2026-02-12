public class CharFrequency {
    public static int[][] getFrequencies(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        int count = 0;
        for (int f : freq) if (f > 0) count++;

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "hello world";
        int[][] frequencies = getFrequencies(input);
        System.out.println("Character\tFrequency");
        for (int[] f : frequencies) {
            System.out.println((char) f[0] + "\t\t" + f[1]);
        }
    }
}

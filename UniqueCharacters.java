public class UniqueCharacters {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static char[] getUniqueCharacters(String text) {
        int len = getLength(text);
        char[] unique = new char[len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[idx++] = ch;
            }
        }
        char[] result = new char[idx];
        System.arraycopy(unique, 0, result, 0, idx);
        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        char[] unique = getUniqueCharacters(input);
        System.out.print("Unique characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }
    }
}

package Problems._0051to_0075._0059_XOR_Decryption;

import Helpers.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class XORDecryption {
    private static final String filePath = "src/Problems/_0059_XOR_Decryption/target.txt";
    private static final ArrayList<char[]> commonWords = new ArrayList<>(Arrays.asList(
            "the".toCharArray(),
            "and".toCharArray(),
            "that".toCharArray()
    ));

    static class PasswordGenerator implements Iterator<char[]>{
        private final char[] current = new char[] {'a', 'a', 'a' - 1};
        @Override
        public boolean hasNext() {
            return current[0] <= 'z';
        }

        @Override
        public char[] next() {
            // Increment the last character first
            current[2]++;

            // Handle carry for 'z'
            if (current[2] > 'z') {
                current[2] = 'a';
                current[1]++;
            }
            if (current[1] > 'z') {
                current[1] = 'a';
                current[0]++;
            }

            // Return a copy to prevent modification outside
            return current;
        }
    }

    public static void solution() {
        String fileString = FileHelper.getFileContentsAsString(filePath);
        char[] encrypted = Arrays.stream(fileString.split(","))
                .mapToInt(Integer::parseInt)
                .map(i -> (char) i)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().toCharArray();
        Iterator<char[]> gen = new PasswordGenerator();
        while (gen.hasNext()) {
            decrypt(encrypted, gen.next());
        }
    }

    public static void decrypt(char[] encrypted, char[] password) {
        int currentIndex = 0;
        int foundWords = 0;
        int[] decrypted = new int[encrypted.length];
        ArrayList<char[]> words = new ArrayList<>(commonWords);

        while (currentIndex < encrypted.length) {
            decrypted[currentIndex] = encrypted[currentIndex] ^ password[currentIndex % password.length];
            for (int i = 0; i < words.size(); i++) {
                char[] word = words.get(i);
                if (word.length <= currentIndex && compare(currentIndex, word, decrypted)) {
                    foundWords += 1;
                    words.remove(word);
                }
            }
            currentIndex++;
        }


        if (foundWords == commonWords.size()) {
            int sum = 0;
            for (int c : decrypted) {
                System.out.print((char) c);
                sum += c;
            }
            System.out.println("\n" + sum);
            for (char c: password) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean compare(int endIndex, char[] toCompare, int[] encrypted) {
        int startIndex = endIndex - toCompare.length + 1;
        for (int i = 0; i < toCompare.length; i++) {
            if (toCompare[i] != encrypted[startIndex + i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        solution();
    }
}

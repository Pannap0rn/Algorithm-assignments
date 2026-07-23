import java.util.Scanner;

public class VowelCheck {

    // Helper check สระ
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Helper check พยัญชนะ (ไม่นับตัวเลข ช่องว่าง และเครื่องหมายพิเศษ)
    private static boolean isConsonant(char ch) {
        ch = Character.toLowerCase(ch);
        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }

    // อัลกอริทึมที่ 1: Recursive Counting
    public static boolean hasMoreVowelsRecursive(String s) {
        int[] counts = countRecursiveHelper(s, 0);
        return counts[0] > counts[1];
    }

    private static int[] countRecursiveHelper(String s, int index) {
        if (s == null || index >= s.length()) {
            return new int[]{0, 0};
        }

        int[] counts = countRecursiveHelper(s, index + 1);
        char ch = s.charAt(index);

        if (isVowel(ch)) {
            counts[0]++;
        } else if (isConsonant(ch)) {
            counts[1]++;
        }

        return counts;
    }

    // อัลกอริทึมที่ 2: Iterative Counting
    public static boolean hasMoreVowelsIterative(String s) {
        if (s == null) return false;

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels++;
            } else if (isConsonant(ch)) {
                consonants++;
            }
        }

        return vowels > consonants;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            int[] counts = countRecursiveHelper(input, 0);
            int vowels = counts[0];
            int consonants = counts[1];
            boolean result = vowels > consonants;

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}

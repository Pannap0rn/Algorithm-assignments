import java.util.Scanner;
public class VowelCheck {

    // Helper check สระ
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Helper check พยัญชนะ
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

    // Helper สำหรับนับและแสดงผล
    public static void printAnalysis(String input) {
        int vowels = 0;
        int consonants = 0;

        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (isVowel(ch)) vowels++;
                else if (isConsonant(ch)) consonants++;
            }
        }

        boolean result = vowels > consonants;
        System.out.println("Input: " + input);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Result: " + result);
    }

    // Main Method: รับ Input จากผู้ใช้
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        printAnalysis(input);

        scanner.close();
    }
}

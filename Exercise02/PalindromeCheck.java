import java.util.Scanner;

public class PalindromeCheck {

    // 1. Reverse and Compare Approach
    public static boolean isPalindromeByReverse(String s) {
        if (s == null) return false;

        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return s.equals(reversed.toString());
    }

    // 2. Recursive Two-Pointer Approach
    public static boolean isPalindromeRecursive(String s, int left, int right) {
        if (s == null) return false;
        if (left >= right) return true;

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            boolean result = isPalindromeRecursive(input, 0, input.length() - 1);
            System.out.println(result);
        }
        scanner.close();
    }
}

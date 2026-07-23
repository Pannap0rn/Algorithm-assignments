import java.util.Scanner;

public class StringReversal {

    // 1. Recursive Approach
    public static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseRecursive(s.substring(0, s.length() - 1));
    }

    // 2. Iterative Approach
    public static String reverseIterative(String s) {
        if (s == null) return null;

        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input:  ");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("Output: " + reverseRecursive(input));
        }
        scanner.close();
    }
}

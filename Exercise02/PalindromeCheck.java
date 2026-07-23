import java.util.Scanner;

public class PalindromeCheck {

    // 1. Iterative Approach
    public static boolean isPalindromeIterative(String str) {
        if (str == null) return false;
        if (str.isEmpty()) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Recursive Approach
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (str == null) return false;

        // Base Case 1: ตัวชี้ชนกันหรือสวนทางกัน (แสดงว่าเป็น Palindrome)
        if (left >= right) return true;

        // Base Case 2: ตัวอักษรฝั่งซ้ายและขวาไม่ตรงกัน
        if (str.charAt(left) != str.charAt(right)) return false;

        // Recursive Case: ขยับตัวชี้ซ้ายไปขวา และตัวชี้ขวาไปซ้าย
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            if (!sc.hasNextLine()) return;

            String input = sc.nextLine();
            if (input == null || input.isEmpty()) {
                System.out.println(true);
            } else {
                boolean result = isPalindromeRecursive(input, 0, input.length() - 1);
                System.out.println(result);
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
        } finally {
            sc.close();
        }
    }
}

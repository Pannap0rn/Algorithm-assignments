import java.util.Scanner;

public class StringReversal {

    // 1. Iterative Approach
    public static String reverseIterative(String str) {
        if (str == null || str.isEmpty()) return str;

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    // 2. Recursive Approach
    public static String reverseRecursive(String str) {
        // Base Case 1
        if (str == null || str.isEmpty()) return str;

        // Base Case 2
        if (str.length() == 1) return str;

        // Recursive Case
        return str.charAt(str.length() - 1) + reverseRecursive(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input:");
            String input = sc.nextLine();

            // แสดงผล Output
            System.out.println("\nOutput");

            // เรียกใช้ Recursive ตามข้อกำหนด
            String result = reverseRecursive(input);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
        } finally {
            sc.close();
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddPartition {

    // 1. Iterative Approach
    public static void partitionIterative(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // ขยับ left ไปทางขวาถ้าเป็นเลขคู่แล้ว
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // ขยับ right ไปทางซ้ายถ้าเป็นเลขคี่แล้ว
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            // สลับตำแหน่งเลขคี่ที่เจอทางซ้าย กับเลขคู่ที่เจอทางขวา
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // 2. Recursive Approach
    public static void partitionRecursive(int[] arr, int left, int right) {
        if (arr == null) return;

        // Base Case
        if (left >= right) return;

        if (arr[left] % 2 == 0) {
            // ถ้าฝั่งซ้ายเป็นเลขคู่อยู่แล้ว ขยับซ้าย
            partitionRecursive(arr, left + 1, right);
        } else if (arr[right] % 2 != 0) {
            // ถ้าฝั่งขวาเป็นเลขคี่อยู่แล้ว ขยับขวา
            partitionRecursive(arr, left, right - 1);
        } else {
            // Recursive Case
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            partitionRecursive(arr, left + 1, right - 1);
        }
    }

    private static int[] parseInputArray(String input) {
        if (input == null || input.trim().isEmpty()) return new int[0];

        String clean = input.replaceAll("[\\[\\]]", "").trim();
        if (clean.isEmpty()) return new int[0];

        String[] tokens = clean.split(",");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i].trim());
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input:");
            if (!sc.hasNextLine()) return;

            String inputStr = sc.nextLine();
            int[] arr = parseInputArray(inputStr);

            partitionRecursive(arr, 0, arr.length - 1);
            System.out.println("\nPossible Output:");
            System.out.println(Arrays.toString(arr));

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid integer array input.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
        } finally {
            sc.close();
        }
    }
}

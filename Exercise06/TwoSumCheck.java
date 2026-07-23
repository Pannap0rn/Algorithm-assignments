import java.util.Arrays;
import java.util.Scanner;

public class TwoSumCheck {

    // 1. Brute Force
    public static boolean findPairBruteForce(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: " + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }
        System.out.println("No pair found");
        return false;
    }

    // 2. Recursive Two-Pointer
    public static boolean findPairRecursive(int[] a, int k, int left, int right) {
        if (left >= right) {
            System.out.println("No pair found");
            return false;
        }

        int sum = a[left] + a[right];
        if (sum == k) {
            System.out.println("Pair found: " + a[left] + " and " + a[right]);
            return true;
        } else if (sum < k) {
            return findPairRecursive(a, k, left + 1, right);
        } else {
            return findPairRecursive(a, k, left, right - 1);
        }
    }

    // 3. Binary Search
    public static boolean findPairBinarySearch(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            int target = k - a[i];
            int index = Arrays.binarySearch(a, i + 1, a.length, target);
            if (index >= 0) {
                System.out.println("Pair found: " + a[i] + " and " + a[index]);
                return true;
            }
        }
        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String lineA = scanner.nextLine().trim();
            String lineK = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

            String arrayData = lineA.substring(lineA.indexOf('[') + 1, lineA.indexOf(']'));
            String[] parts = arrayData.split(",");
            int[] a = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i].trim());
            }

            int k = Integer.parseInt(lineK.replaceAll("[^0-9]", ""));

            System.out.println("ผลลัพธ์");
            findPairRecursive(a, k, 0, a.length - 1);
        }

        scanner.close();
    }
}

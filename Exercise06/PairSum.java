import java.util.Arrays;
import java.util.Scanner;

public class PairSum {

    // อัลกอริทึมที่ 1: Brute Force
    public static boolean findPairBruteForce(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: " + a[i] + " and " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }

    // อัลกอริทึมที่ 2: Recursive Two-Pointer
    public static boolean findPairRecursive(int[] a, int k, int left, int right) {
        if (left >= right) return false;

        int sum = a[left] + a[right];
        if (sum == k) {
            System.out.println("Pair found: " + a[left] + " and " + a[right]);
            return true;
        }
        if (sum < k) return findPairRecursive(a, k, left + 1, right);
        return findPairRecursive(a, k, left, right - 1);
    }

    // อัลกอริทึมที่ 3: Binary Search
    public static boolean findPairBinarySearch(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            int target = k - a[i];
            int index = Arrays.binarySearch(a, i + 1, a.length, target);
            if (index > i) {
                System.out.println("Pair found: " + a[i] + " and " + a[index]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input A:");
        String inputA = sc.nextLine().replaceAll("[\\[\\]]", "");
        int[] a = Arrays.stream(inputA.split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print("k = ");
        int k = sc.nextInt();

        System.out.println("\nผลลัพธ์");
        findPairRecursive(a, k, 0, a.length - 1);

        sc.close();
    }
}

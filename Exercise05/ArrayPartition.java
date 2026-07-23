import java.util.Arrays;
import java.util.Scanner;

public class ArrayPartition {

    // 1. Recursive Partition
    public static void partitionRecursive(int[] a, int k, int left, int right) {
        if (left >= right) return;
        if (a[left] <= k) partitionRecursive(a, k, left + 1, right);
        else if (a[right] > k) partitionRecursive(a, k, left, right - 1);
        else {
            int temp = a[left]; a[left] = a[right]; a[right] = temp;
            partitionRecursive(a, k, left + 1, right - 1);
        }
    }

    // 2. Iterative Partition
    public static void partitionIterative(int[] a, int k) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] <= k) left++;
            while (left < right && a[right] > k) right--;
            if (left < right) {
                int temp = a[left]; a[left] = a[right]; a[right] = temp;
                left++; right--;
            }
        }
    }

    // 3. Sorting-Based Algorithm
    public static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input A:");
        String inputA = sc.nextLine().replaceAll("[\\[\\]]", "");
        int[] arr = Arrays.stream(inputA.split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print("k = ");
        int k = sc.nextInt();
        partitionRecursive(arr, k, 0, arr.length - 1);
        System.out.println("\nPossible Output:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}

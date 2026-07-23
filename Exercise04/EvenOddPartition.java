import java.util.Arrays;
import java.util.Scanner;

public class EvenOddPartition {

    // 1. Recursive Two-Pointer
    public static void rearrangeRecursive(int[] a, int left, int right) {
        if (left >= right) return;
        if (a[left] % 2 == 0) rearrangeRecursive(a, left + 1, right);
        else if (a[right] % 2 != 0) rearrangeRecursive(a, left, right - 1);
        else {
            int temp = a[left]; a[left] = a[right]; a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    // 2. Iterative Two-Pointer
    public static void rearrangeTwoPointer(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] % 2 == 0) left++;
            while (left < right && a[right] % 2 != 0) right--;
            if (left < right) {
                int temp = a[left]; a[left] = a[right]; a[right] = temp;
                left++; right--;
            }
        }
    }

    // 3. Extra Array
    public static int[] rearrangeExtraArray(int[] a) {
        int[] res = new int[a.length];
        int left = 0, right = a.length - 1;
        for (int n : a) res[n % 2 == 0 ? left++ : right--] = n;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");

        // รับค่า
        String inputStr = sc.nextLine().replaceAll("[\\[\\]]", "");
        int[] arr = Arrays.stream(inputStr.split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        rearrangeRecursive(arr, 0, arr.length - 1);

        System.out.println("\nPossible Output:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}

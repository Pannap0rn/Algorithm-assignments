import java.util.Arrays;
import java.util.Scanner;

public class PartitionByK {

    // 1. Recursive Partition
    public static void partitionRecursive(int[] a, int k, int left, int right) {
        if (left >= right) return;

        if (a[left] <= k) {
            partitionRecursive(a, k, left + 1, right);
        } else if (a[right] > k) {
            partitionRecursive(a, k, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            partitionRecursive(a, k, left + 1, right - 1);
        }
    }

    // 2. Iterative Partition
    public static void partitionIterative(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            if (a[left] <= k) {
                left++;
            } else if (a[right] > k) {
                right--;
            } else {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    // 3. Sorting-Based Algorithm
    public static void partitionBySorting(int[] a, int k) {
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String lineA = scanner.nextLine().trim(); // A = [12, 4, 7, 15, 3, 10, 8]
            String lineK = scanner.hasNextLine() ? scanner.nextLine().trim() : ""; // k = 8

            // Parse array A
            String arrayData = lineA.substring(lineA.indexOf('[') + 1, lineA.indexOf(']'));
            String[] parts = arrayData.split(",");
            int[] a = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                a[i] = Integer.parseInt(parts[i].trim());
            }

            // Parse k
            int k = Integer.parseInt(lineK.replaceAll("[^0-9]", ""));

            // เรียกใช้อัลกอริทึมที่ 1 (Recursive Partition)
            partitionRecursive(a, k, 0, a.length - 1);

            System.out.println("ผลลัพธ์ที่เป็นไปได้");
            System.out.println(Arrays.toString(a));
        }

        scanner.close();
    }
}

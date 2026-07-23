import java.util.Arrays;
import java.util.Scanner;

public class EvenOddRearrange {

    // อัลกอริทึมที่ 1: Recursive Two-Pointer
    public static void rearrangeRecursive(int[] a, int left, int right) {
        if (left >= right) return;

        if (a[left] % 2 == 0) {
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            rearrangeRecursive(a, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    // อัลกอริทึมที่ 2: Iterative Two-Pointer
    public static void rearrangeTwoPointer(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            if (a[left] % 2 == 0) {
                left++;
            } else if (a[right] % 2 != 0) {
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

    // อัลกอริทึมที่ 3: Extra Array
    public static int[] rearrangeExtraArray(int[] a) {
        int[] result = new int[a.length];
        int index = 0;

        for (int num : a) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }

        for (int num : a) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            // แปลงข้อความรูปแบบ [7, 2, 9, 4, 1, 6, 3, 8] เป็น int[]
            line = line.replaceAll("[\\[\\]\\s]", "");
            String[] parts = line.split(",");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            // เรียกใช้อัลกอริทึมที่ 1 (Recursive)
            rearrangeRecursive(arr, 0, arr.length - 1);

            System.out.println("\nPossible Output:");
            System.out.println(Arrays.toString(arr));
        }

        scanner.close();
    }
}

public class PalindromeCheck {
    private static String preprocess(String s) {
        if (s == null) return "";
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
    // อัลกอริทึมที่ 1: Reverse and Compare
    public static boolean isPalindromeByReverse(String s) {
        String cleaned = preprocess(s);
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    // อัลกอริทึมที่ 2: Recursive Two-Pointer
    public static boolean isPalindromeRecursive(String s, int left, int right) {
        // Base case 1
        if (left >= right) {
            return true;
        }
        // Base case 2
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        // Recursive step
        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    // Overload Method
    public static boolean isPalindromeRecursive(String s) {
        String cleaned = preprocess(s);
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "racecar",
                "level",
                "algorithm",
                "gohangasalamiimalasagnahog",
                "A man, a plan, a canal: Panama" // ตัวอย่างละเว้นช่องว่าง/ตัวพิมพ์ใหญ่-เล็ก
        };

        System.out.println("=== Testing Algorithm 1: Reverse & Compare ===");
        for (String tc : testCases) {
            System.out.println("\"" + tc + "\" -> " + isPalindromeByReverse(tc));
        }

        System.out.println("\n=== Testing Algorithm 2: Recursive Two-Pointer ===");
        for (String tc : testCases) {
            System.out.println("\"" + tc + "\" -> " + isPalindromeRecursive(tc));
        }
    }
}

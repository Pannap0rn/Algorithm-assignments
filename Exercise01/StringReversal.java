public class StringReversal {
    // Recursive1
    public static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseRecursive(s.substring(0, s.length() - 1));
    }
    // Iteration2
    public static String reverseIterative(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String generateString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (i % 26)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String exampleInput = "pots&pans";
        System.out.println("=== Example Test ===");
        System.out.println("Input: " + exampleInput);
        System.out.println("Output : " + reverseIterative(exampleInput));
        System.out.println("--------------------------------------------------\n");

        int[] testSizes = {10, 100, 1000, 10000};

        System.out.println("=== Performance Benchmark (Execution Time) ===");
        System.out.printf("%-12s | %-20s | %-20s\n", "Length (N)", "Recursive (ms)", "Iterative (ms)");
        System.out.println("--------------------------------------------------");

        for (int size : testSizes) {
            String testInput = generateString(size);

            long startTimeIter = System.nanoTime();
            reverseIterative(testInput);
            long endTimeIter = System.nanoTime();
            double timeIterMs = (endTimeIter - startTimeIter) / 1_000_000.0;
            double timeRecMs = -1;
            try {
                long startTimeRec = System.nanoTime();
                reverseRecursive(testInput);
                long endTimeRec = System.nanoTime();
                timeRecMs = (endTimeRec - startTimeRec) / 1_000_000.0;
            } catch (StackOverflowError e) {
            }

            String recResultStr = (timeRecMs >= 0) ? String.format("%.4f ms", timeRecMs) : "StackOverflowError";
            String iterResultStr = String.format("%.4f ms", timeIterMs);

            System.out.printf("%-12d | %-20s | %-20s\n", size, recResultStr, iterResultStr);
        }
    }
}

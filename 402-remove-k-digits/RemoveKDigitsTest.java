import java.util.Stack;

/**
 * Regression tests for LeetCode 402 - Remove K Digits.
 *
 * Run with:
 *   javac RemoveKDigitsTest.java && java RemoveKDigitsTest
 */
public class RemoveKDigitsTest {

    // Inline the Solution class so the test is self-contained.
    static class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> st = new Stack<>();
            if (k == num.length()) return "0";

            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                    st.pop();
                    k--;
                }
                st.push(ch);
            }
            while (k > 0) {
                st.pop();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            return sb.length() > 0 ? sb.toString() : "0";
        }
    }

    private static int passed = 0;
    private static int failed = 0;

    private static void assertResult(String testName, String num, int k, String expected) {
        Solution sol = new Solution();
        String actual = sol.removeKdigits(num, k);
        if (actual.equals(expected)) {
            passed++;
            System.out.println("  PASS: " + testName);
        } else {
            failed++;
            System.out.println("  FAIL: " + testName
                    + " | input=(" + num + ", " + k + ")"
                    + " | expected=\"" + expected + "\""
                    + " | got=\"" + actual + "\"");
        }
    }

    // -------- LeetCode-provided examples --------

    private static void testLeetCodeExamples() {
        System.out.println("[LeetCode Examples]");
        assertResult("Example 1", "1432219", 3, "1219");
        assertResult("Example 2", "10200", 1, "200");
        assertResult("Example 3 – remove all digits", "10", 2, "0");
    }

    // -------- Edge case: all digits are the same --------

    private static void testAllSameDigits() {
        System.out.println("[All Same Digits]");
        assertResult("All 1s, remove 1", "1111", 1, "111");
        assertResult("All 1s, remove 3", "1111", 3, "1");
        assertResult("All 5s, remove all", "5555", 4, "0");
        assertResult("All 9s, remove half", "999999", 3, "999");
        assertResult("Single repeated digit", "7", 1, "0");
    }

    // -------- Edge case: k close to length of num --------

    private static void testKCloseToLength() {
        System.out.println("[k Close to Length]");
        assertResult("k == length", "12345", 5, "0");
        assertResult("k == length - 1", "12345", 4, "1");
        assertResult("k == length - 1 (descending)", "54321", 4, "1");
        assertResult("k == length - 1 (mixed)", "41352", 4, "1");
        assertResult("k == length - 2", "987654", 4, "54");
    }

    // -------- Edge case: leading zeros after removal --------

    private static void testLeadingZeros() {
        System.out.println("[Leading Zeros After Removal]");
        assertResult("Leading zeros – 10200 k=1", "10200", 1, "200");
        assertResult("Leading zeros – 100200 k=1", "100200", 1, "200");
        assertResult("All zeros remain", "10000", 1, "0");
        assertResult("Multiple leading zeros", "10001", 1, "1");
        assertResult("Zero sandwich", "20010", 1, "10");
    }

    // -------- Edge case: single digit --------

    private static void testSingleDigit() {
        System.out.println("[Single Digit]");
        assertResult("Single digit 0", "0", 1, "0");
        assertResult("Single digit 9", "9", 1, "0");
    }

    // -------- Already sorted (ascending) – removals come from the tail --------

    private static void testAscendingDigits() {
        System.out.println("[Ascending Digits]");
        assertResult("Ascending 12345 k=1", "12345", 1, "1234");
        assertResult("Ascending 12345 k=2", "12345", 2, "123");
        assertResult("Ascending 123456789 k=5", "123456789", 5, "1234");
    }

    // -------- Descending digits – removals come from the front --------

    private static void testDescendingDigits() {
        System.out.println("[Descending Digits]");
        assertResult("Descending 54321 k=1", "54321", 1, "4321");
        assertResult("Descending 54321 k=2", "54321", 2, "321");
        assertResult("Descending 987654321 k=5", "987654321", 5, "4321");
    }

    // -------- Larger / mixed inputs --------

    private static void testMixedInputs() {
        System.out.println("[Mixed / Larger Inputs]");
        assertResult("Mixed 112 k=1", "112", 1, "11");
        assertResult("Mixed 1234567890 k=9", "1234567890", 9, "0");
        assertResult("Peak in middle 1321 k=1", "1321", 1, "121");
        assertResult("Two peaks 143221 k=2", "143221", 2, "1221");
        assertResult("Remove nothing k=0", "9876", 0, "9876");
    }

    // -------- Runner --------

    public static void main(String[] args) {
        testLeetCodeExamples();
        testAscendingDigits();
        testDescendingDigits();
        testAllSameDigits();
        testKCloseToLength();
        testLeadingZeros();
        testSingleDigit();
        testMixedInputs();

        System.out.println();
        System.out.println("Results: " + passed + " passed, " + failed + " failed, "
                + (passed + failed) + " total");

        if (failed > 0) {
            System.exit(1);
        }
    }
}

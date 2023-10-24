
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isPositive = (dividend ^ divisor) >= 0;
        // in case dividend == Integer.MIN_VALUE && divisor != -1
        long a = dividend >= 0 ? dividend : -(long) dividend;
        long b = divisor >= 0 ? divisor : -(long) divisor;
        int result = 0;
        while (a >= b) {
            int times = 1;
            long subtractor = b;
            while ((subtractor << 1) <= a) {
                subtractor <<= 1;
                times <<= 1;
            }
            a -= subtractor;
            result += times;
        }
        return isPositive ? result : -result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

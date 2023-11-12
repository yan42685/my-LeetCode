
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

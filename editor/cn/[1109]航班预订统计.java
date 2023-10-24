
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            result[first - 1] += seats;
            if (last < n) {
                result[last] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
// 以下解法仅作练习，答题还是用上面的比较好
//    public int[] corpFlightBookings(int[][] bookings, int n) {
//        DiffArray diffArray = new DiffArray(new int[n]);
//        for (int[] booking : bookings) {
//            diffArray.increment(booking[0] - 1, booking[1] - 1, booking[2]);
//        }
//        return diffArray.result();
//    }
//
//    private class DiffArray {
//        private int[] diff = null;
//
//        public DiffArray(int[] array) {
//            if (array == null || array.length == 0) {
//                throw RuntimeException("Array can't be null or empty");
//            }
//            this.diff = new int[array.length];
//            this.diff[0] = array[0];
//            for (int i = 1; i < array.length; i++) {
//                this.diff[i] = array[i] - array[i - 1];
//            }
//        }
//
//        public boolean increment(int left, int right, int value) {
//            if (this.diff == null || left < 0 || right > this.diff.length - 1 || left > right) {
//                return false;
//            }
//            diff[left] += value;
//            if (right != this.diff.length - 1) {
//                diff[right + 1] -= value;
//            }
//            return true;
//        }
//
//        public int[] result() {
//            int[] result = new int[this.diff.length];
//            result[0] = this.diff[0];
//            for (int i = 1; i < this.diff.length; i++) {
//                result[i] = result[i - 1] + this.diff[i];
//            }
//            return result;
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

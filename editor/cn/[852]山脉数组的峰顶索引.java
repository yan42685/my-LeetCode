
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else if (mid + 1 < arr.length && arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                while (mid > 0 && arr[mid - 1] == target) {
                    --mid;
                }
                // arr[0]可能也可能是target
                return arr[0] == target ? 0 : mid;
            } else if (arr[mid] > arr[left]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                ++left;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

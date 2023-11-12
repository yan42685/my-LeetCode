import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int i = binarySearch(list, num);
            if (i == list.size()) {
                list.add(num);
            } else {
                list.set(i, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        if (list.size() == 0) {
            return 0;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left ) / 2;
            if (num == list.get(mid)) {
                return mid;
            } else if (num < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

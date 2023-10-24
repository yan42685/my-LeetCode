import java.util.Collections;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    int[] temp;
    int[] res;
    int[] indexes;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        temp = new int[nums.length];
        res = new int[nums.length];
        indexes = new int[nums.length];
        for (int i = 0; i < nums.length;i++) {
            indexes[i] = i;
        }
        sort(nums, 0, nums.length - 1);
        for (int count : res) {
            result.add(count);
        }
        return result;
    }

    private void sort(int[] nums, int left, int right) {
        // 只有一个元素时停止递归
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                indexes[k] = temp[j++];
            } else if (j == right + 1) {
                indexes[k] = temp[i++];
                res[indexes[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i++];
                res[indexes[k]] += (j - 1 - mid);
            } else {
                indexes[k] = temp[j++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

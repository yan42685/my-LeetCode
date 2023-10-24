import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // nums1升序
        Arrays.sort(nums1);
        // nums2降序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                b[1] - a[1]
        );
        for (int i = 0; i < nums2.length; i++) {
            // 放入索引和对应的值
            pq.offer(new int[]{i, nums2[i]});
        }
        int[] result = new int[nums1.length];
        int left = 0;
        int right = nums1.length - 1;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            if (nums1[right] > pair[1]) {
                result[pair[0]] = nums1[right];
                --right;
            } else {
                result[pair[0]] = nums1[left];
                ++left;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

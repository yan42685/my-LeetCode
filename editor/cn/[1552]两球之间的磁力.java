
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (isValid(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid(int[] position, int m, int minDistance) {
        int currPosition = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - currPosition >= minDistance) {
                ++count;
                if (count == m) {
                    return true;
                }
                currPosition = position[i];
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

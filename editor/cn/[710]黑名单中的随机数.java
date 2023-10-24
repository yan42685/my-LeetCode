import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int end;
    private Map<Integer, Integer> mapping;
    private Random rand = new Random();

    public Solution(int n, int[] blacklist) {
        mapping = new HashMap<>();
        Set<Integer> blackSet = new HashSet<>();
        for (int b : blacklist) {
            blackSet.add(b);
        }
        end = n - blacklist.length;
        int p = end;
        for (int b : blacklist) {
            if (b < end) {
                while (blackSet.contains(p)) {
                    ++p;
                }
                // 将小于end的存在于blacklist的数映射到后半段不属于blacklist的数
                mapping.put(b, p);
                ++p;
            }
        }
    }

    public int pick() {
        int pick = rand.nextInt(end);
        if (mapping.containsKey(pick)) {
            return mapping.get(pick);
        } else {
            return pick;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

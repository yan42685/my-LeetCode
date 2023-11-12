import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
    private static class Node {
        String key;
        String value;
        int time;

        public Node(String k, String v, int time) {
            key = k;
            value = v;
            this.time = time;
        }
    }

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // 返回新增value，然后添加
        map.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Node(key, value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Node> list = map.getOrDefault(key, Collections.emptyList());
        if (list.isEmpty()) {
            return "";
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).time < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 循环结束后，left代表 >= target的最小值索引，范围是[min, max+1]
        // right 代表 <= target的最小值索引，范围是[min-1, max]
        return right == -1 ? "" : list.get(right).value;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

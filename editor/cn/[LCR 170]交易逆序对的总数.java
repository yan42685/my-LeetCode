
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] temp;
    private int count;

    public int reversePairs(int[] record) {
        if (record == null || record.length == 0) {
            return 0;
        }
        temp = new int[record.length];
        count = 0;
        sort(record, 0, record.length - 1);
        return count;
    }

    private void sort(int[] record, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(record, left, mid);
        sort(record, mid + 1, right);
        merge(record, left, mid, right);
    }

    private void merge(int[] record, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = record[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                record[k] = temp[j++];
            } else if (j == right + 1) {
                record[k] = temp[i++];
                count += (right - mid);
            } else if (temp[i] <= temp[j]) {
                record[k] = temp[i++];
                count += (j - 1 - mid);
            } else {
                record[k] = temp[j++];
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

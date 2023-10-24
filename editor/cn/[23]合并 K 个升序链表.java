
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);
        return mergeTwoList(leftList, rightList);
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = mergeTwoList(left.next, right);
            return left;
        } else {
            right.next = mergeTwoList(right.next, left);
            return right;
        }
    }
}

//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        ListNode dummy = new ListNode();
//        ListNode p = dummy;
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
//        for (ListNode list : lists) {
//            if (list != null) {
//                pq.add(list);
//            }
//        }
//        while (!pq.isEmpty()) {
//            ListNode node = pq.remove();
//            p.next = node;
//            p = p.next;
//            if (node.next != null) {
//                pq.add(node.next);
//            }
//        }
//        return dummy.next;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    private ListNode successor = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (listLength(head) < k) {
            return head;
        }
        ListNode newHead = reverseN(head, k);
        head.next = reverseKGroup(this.successor, k);
        return newHead;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            this.successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = this.successor;
        return newHead;
    }
    private int listLength(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

//    private int listLength(ListNode head) {
//        if (head == null) {
//            return 0;
//        }
//        return 1 + listLenth(head.next);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

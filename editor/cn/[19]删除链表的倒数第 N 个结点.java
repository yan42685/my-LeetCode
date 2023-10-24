
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < n; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            }
        }
        ListNode p2 = dummy;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // remove target node
        p2.next = p2.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

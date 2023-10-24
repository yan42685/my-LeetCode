
//leetcode submit region begin(Prohibit modification and deletion)


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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        // Find the previous node of the first node with a value greater than or equal to x
        while (p1 != null && p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }

        ListNode p2 = p1.next;
        // Move all nodes with a value less than x to the front of p1
        while (p2 != null && p2.next != null) {
            if (p2.next.val >= x) {
                p2 = p2.next;
            } else {
                moveNode(p1, p2);
                p1 = p1.next;
            }
        }
        return dummy.next;
    }

    private void moveNode(ListNode p1, ListNode p2) {
        ListNode target = p2.next;
        p2.next = target.next;
        target.next = p1.next;
        p1.next = target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

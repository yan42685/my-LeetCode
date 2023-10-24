
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverse(slow.next);
        ListNode leftHalf = head;
        ListNode rightHalf = tail;
        boolean result = true;
        while (rightHalf != null) {
            if (leftHalf.val != rightHalf.val) {
                result = false;
                break;
            }
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        leftHalf.next = reverse(tail);
        return result;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

//    private ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

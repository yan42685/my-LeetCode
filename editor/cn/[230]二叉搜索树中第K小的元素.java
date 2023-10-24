
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int rank;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        rank = 0;
        result = -1;
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null || result >= 0) {
            return;
        }
        traverse(node.left, k);
        ++rank;
        if (rank== k) {
            result = node.val;
            return;
        }
        traverse(node.right, k);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

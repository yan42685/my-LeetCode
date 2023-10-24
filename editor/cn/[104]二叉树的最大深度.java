
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
// 遍历思路
class Solution {
    private int currDepth = 0;
    private int result = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }
    private void traverse(TreeNode root) {
        if (root != null) {
            ++currDepth;
            // leaf node
            if (root.left == null && root.right == null) {
                result = Math.max(result, currDepth);
            }
            traverse(root.left);
            traverse(root.right);
            --currDepth;
        }
    }
}

// 分治思路
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = traverse(node.left);
        int rightMaxDepth = traverse(node.right);
        maxDiameter = Math.max(maxDiameter, leftMaxDepth + rightMaxDepth);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

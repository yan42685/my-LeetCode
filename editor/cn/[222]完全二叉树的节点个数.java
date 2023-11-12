
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
// 两种情况：左子树高度=右子树高度+1  ;  左子树高度 == 右子树高度
// 2^0 + 2^1 ... + 2^(h-1) = 2^h - 1
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight + 1) {  // 右边是满二叉树
            return countNodes(root.left) + (1 << rightHeight);
        } else {  // 左边是满二叉树
            return countNodes(root.right) + (1 << leftHeight);
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getHeight(node.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

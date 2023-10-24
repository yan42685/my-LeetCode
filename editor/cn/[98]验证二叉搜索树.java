
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
// 习惯养成：
// 通过递归函数的参数传递约束 或 引用
// 通过实例变量传递累计值
class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean traverse(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }
        // BST满足 min < node.val < max
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return traverse(node.left, min, node.val) && traverse(node.right, node.val, max);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

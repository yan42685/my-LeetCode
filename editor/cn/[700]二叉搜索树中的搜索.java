
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root, val);
    }
    private TreeNode traverse(TreeNode node, int val)  {
        if (node == null) {
            return null;
        }
        if (val == node.val) {
            return node;
        } else if (val < node.val) {
            return traverse(node.left, val);
        } else {
            return traverse(node.right, val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

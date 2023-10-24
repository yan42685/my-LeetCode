
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            if (root.left == null) {
                return root.right;
            }
            // 最终指向左子树最大节点，然后和右子树
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = root.right;
            return root.left;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right =deleteNode(root.right, key);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

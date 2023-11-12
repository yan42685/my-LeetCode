
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (x > p.val && x > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (x < p.val && x < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    private int postIndex;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);
        int pivot = map.get(value);
        // 后序遍历的顺序是左-右-根，所以当根据后序遍历反过来(自顶向下)构建二叉树时
        // 新节点的顺序是根-右-左, 所以需要先处理右子树
        root.right = build(postorder, pivot + 1, right);
        root.left = build(postorder, left, pivot - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

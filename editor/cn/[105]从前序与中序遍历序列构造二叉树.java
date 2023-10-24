
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
// 因为没有重复元素，所以可以用Hashmap保存index
// 时间复杂度O(n) 空间复杂度O(n)
class Solution {
    private int preIndex;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // 方便根据新节点的值获取inorder中pivot的位置
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        // 先序遍历序列获取新节点的值
        int value = preorder[preIndex++];
        // 中序遍历序列划分左右子树
        TreeNode root = new TreeNode(value);
        int pivot = map.get(value);
        root.left = build(preorder, left, pivot - 1);
        root.right = build(preorder, pivot + 1, right);
        return root;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

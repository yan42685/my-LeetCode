
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

// preorder当前节点的下一个节点 是postorder左子树序列的最后一个节点
// 根据preorder进行dfs创建二叉树，preorder和postorder的左右子树划分共同缩小递归条件
class Solution {
    private int preIndex;
    private Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return construct(preorder, 0, preorder.length - 1,
                0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        int value = preorder[preIndex++];
        TreeNode node = new TreeNode(value);
        if (preIndex <= preEnd) {
            // 核心思路：preorder当前节点的下一个节点 是postorder左子树序列的最后一个节点
            int postPivot = map.get(preorder[preIndex]);
            int leftNodesCount = postPivot - postStart + 1;
            node.left = construct(preorder, preStart + 1, preStart + leftNodesCount,
                    postStart, postPivot);
            node.right = construct(preorder, preStart + leftNodesCount + 1, preEnd,
                    postPivot + 1, postEnd - 1);
        }
        return node;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

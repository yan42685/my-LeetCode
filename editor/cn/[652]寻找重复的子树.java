
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashMap;
import java.util.LinkedList;

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
// 本质是用带叶子节点的[先序序列]唯一表示子树,
// 只是代码中用到了后序遍历的写法
// sb.append(node.val).append(SEPARATOR);  这句放在先序和后序都行，但是中序不行,
// 因为带叶子节点的中序序列不能唯一表示二叉树
class Solution {
    private static final String LEAF = "#";
    private static final String SEPARATOR = ",";
    private Map<String, Integer> map;
    private List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new LinkedList<>();
        traverse(root);
        return result;
    }

    private String traverse(TreeNode node) {
        if (node == null) {
            return LEAF + SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(SEPARATOR);
        sb.append(traverse(node.left));
        sb.append(traverse(node.right));

        String subTree = sb.toString();
        map.put(subTree, map.getOrDefault(subTree, 0) + 1);
        if (map.get(subTree) == 2) {
            result.add(node);
        }
        return subTree;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String LEAF = "#";
    private static final String SEPARATOR = ",";
    private int preIndex;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(LEAF).append(SEPARATOR);
            return;
        }
        sb.append(node.val).append(SEPARATOR);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        preIndex = 0;
        return construct(data.split(SEPARATOR));
    }

    private TreeNode construct(String[] preorder) {
        if (preIndex >= preorder.length) {
            return null;
        }
        String value = preorder[preIndex++];
        if (LEAF.equals(value)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = construct(preorder);
        node.right = construct(preorder);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

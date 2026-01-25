/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // DFS (Preorder)
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        
        // Input: [1,2,3,null,null,4,5,6,7]
        // Output(Level order): 1,2,null,null,3,4,6,null,7,null,5,null,null,
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // DFS (Preorder)
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));

        // Input: 1,2,null,null,3,4,6,null,7,null,5,null,null,
        // Output(Pre order): [1, 2, null, null, 3, 4, 6, null, 7, null, 5, null, null]
        return dfs(queue);
    }

    private TreeNode dfs(Deque<String> queue) {
        String val = queue.poll();
        if("null".equals(val)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

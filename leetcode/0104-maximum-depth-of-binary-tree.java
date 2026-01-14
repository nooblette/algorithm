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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int depth) {
        // 더이상 방문할 노드가 없는 경우
        if(node == null) {
            return depth;
        }

        // 다음 노드 방문 후 더 큰 깊이 반환
        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }
}

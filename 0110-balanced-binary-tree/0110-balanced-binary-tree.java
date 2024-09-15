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
    public int dfs(TreeNode node) {
        // 리프 노드에 도달하면 left와 right는 0을 반환한다.
        if(node == null) {
            return 0;
        }

        // 왼쪽과 오른쪽 자식의 높이를 반환한다.
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 각 자식의 균형이 이미 깨져있거나, 높이차가 1보다 크다면 균형이 깨졌다는 의미로 -1을 반환한다.
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        // 현재 노드의 높이를 반환한다.
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}
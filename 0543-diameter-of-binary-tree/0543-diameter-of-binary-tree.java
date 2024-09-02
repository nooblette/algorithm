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
    int longest = 0;
    
    public int dfs(TreeNode node) {
        // 리프 노드 예외 처리
        if(node == null) {
            return -1;
        }
        
        // 왼쪽과 오른쪽 노드의 상탯값 계산
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 가장 긴 직경 계산
        longest = Math.max(this.longest, left + right + 2);

        // 상탯값 반환
        return Math.max(left, right) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        // 재귀 DFS 시작
        dfs(root);
        return longest;
    }
}
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

    // 자식 노드가 있는 동안 반복
    public int dfs(TreeNode cur, int depth) {
        // 리프노드인 경우 현재 깊이를 반환
        if(cur == null) {
            return depth;
        }

        int answer = 0;
        
        // 왼쪽 자식 노드 탐색
        answer = Math.max(answer, dfs(cur.left, depth + 1));

        // 오른쪽 자식 노드 탐색
        answer = Math.max(answer, dfs(cur.right, depth + 1));
        
        return answer;
    }
    
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
}
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
    int answer = 0;
    
    private int dfs(TreeNode node, int parentVal) {
        // 리프 노드인 경우와 예외 처리
        if(node == null) {
            // 동일한 값의 경로가 없으므로 0 반환
            return 0;
        }
        
        // 왼쪽 자식 노드 탐색, 현재 노드에서 왼쪽 자식 노드의 동일한 값 경로를 구한다.
        int left = dfs(node.left, node.val);
        
        // 오른쪽 자식 노드 탐색, 현재 노드에서 오른쪽 자식 노드의 동일한 값 경로를 구한다.
        int right = dfs(node.right, node.val);
        
        // 동일한 값 경로 갱신
        answer = Math.max(answer, left + right);
        
        // 부모 노드의 값과 현재 노드의 값이 같다면 길이를 1 증가하여 반환
        if(parentVal == node.val) {
            return Math.max(left, right) + 1;
        }
        
        // 부모 노드의 값과 현재 노드의 값이 다른 경우 - 동일한 값 경로가 깨지므로 0으로 초기화
        return 0;
        
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root, -1);
        return answer;
    }
}
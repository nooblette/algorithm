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
    int result; 
    
    private int dfs(TreeNode node) {
        // 예외 처리 및 리프 노드까지 도달했을때
        if(node == null) {
            return 0;
        }
        
        // 왼쪽 자식에 대해 dfs
        int left = dfs(node.left);
        
        // 현재 노드와 자식 노드의 값이 동일한 경우
        if(node.left != null && node.left.val == node.val) {
            left += 1;
        } else {
            // 현재 노드와 자식 노드의 값이 상이한 경우(동일한 값 경로가 깨지는 경우)
            left = 0;
        }
        
        // 오른쪽 자식에 대해 dfs
        int right = dfs(node.right);
        
        // 현재 노드와 자식 노드의 값이 동일한 경우
        if(node.right != null && node.right.val == node.val) {
            right += 1;
        } else {
            // 현재 노드와 자식 노드의 값이 상이한 경우(동일한 값 경로가 깨지는 경우)
            right = 0;
        }      
        
        // 결과 값 갱신 - 동일한 값이 깨지는 경우 left 혹은 right를 0으로 초기화 하였다.
        // 따라서 두 값의 합은 결국 가장 긴 경로의 길이가 된다.
        result = Math.max(result, left + right);
        
        // 두 값 중 큰 값 반환, 반환 값은 부모 노드의 동일한 값 경로를 갱신하는데 다시 사용된다.
        return Math.max(left, right);
        
    }
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }
}
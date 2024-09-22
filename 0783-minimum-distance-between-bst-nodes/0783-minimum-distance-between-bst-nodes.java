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
    int result = Integer.MAX_VALUE;
    
    // 트리를 dfs 탐색
    public void dfs(TreeNode node, List<TreeNode> visited) {
        // 예외 처리
        if(node == null) {
            return;
        }
        
        for(TreeNode v : visited) {
            // 최솟값 갱신
            if(Math.abs(v.val - node.val) < result) {
                result = Math.abs(v.val - node.val);
            }
        }
        
        visited.add(node);
        dfs(node.left, visited);
        dfs(node.right, visited);
        visited.remove(node);
    }
    
    public int minDiffInBST(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }
}
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
    public TreeNode invertTree(TreeNode root) {
        // 빈 노드에 도달하면 null 반환
        if(root == null) {
            return null;
        }
        
        // 왼쪽/오른쪽 자식 노드 스왑
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        // 왼쪽 자식 노드 dfs
        invertTree(root.left);
        
        // 오른쪽 자식 노드 dfs
        invertTree(root.right);
        
        return root;
    }
}
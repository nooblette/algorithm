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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {        
        // 탐색 종료
        if(root1 == null && root2 == null) {
            return null;
        }
        
        // 두 트리 중 한 트리만 노드가 존재하는 경우
        if(root1 == null) {
            return root2;
        }
        
        if(root2 == null) {
            return root1;
        }
        
        // 두 노드를 합산해야하는 경우
        TreeNode merged = new TreeNode(root1.val + root2.val);

        // 기존 자식과 연결
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        
        return merged;
    }
}
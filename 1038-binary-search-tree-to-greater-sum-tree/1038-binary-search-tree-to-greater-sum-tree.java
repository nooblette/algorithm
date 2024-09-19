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
    // 각 노드의 값(트리를 탐색하면서 구한 최대 값)을 저장
    int val = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        // 예외 처리
        if(root == null) {
            return root;
        }
        
        // 오른쪽 자식 노드부터 탐색
        bstToGst(root.right);
        
        // 노드의 값을 val에 누적
        val += root.val;
        
        // 노드 값 업데이트
        root.val = val;
        
        // 왼쪽 자식 노드도 탐색
        bstToGst(root.left);
        
        return root;
    }
}
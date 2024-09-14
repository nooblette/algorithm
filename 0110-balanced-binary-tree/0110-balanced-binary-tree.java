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
    private int getHeight(TreeNode node) {
        // 예외 처리
        if(node == null) {
            return 0;
        }
        
        // 왼쪽 서브 트리의 높이 반환
        int leftHeight = getHeight(node.left);      
        if(leftHeight == -1) {
            // 왼쪽 서브 트리의 균형이 이미 깨진 경우
            return -1;
        }
        
        // 오른쪽 서브 트리의 높이 반환
        int rightHeight = getHeight(node.right);      
        if(rightHeight == -1) {
            // 오른쪽 서브 트리의 균형이 이미 깨진 경우
            return -1;
        }
        
        // 두 서브 트리의 높이 차이가 1보다 크다면 -1 반환(균형이 깨진 경우)
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;        
    }
}
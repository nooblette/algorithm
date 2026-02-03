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
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        // 예외 처리
        if(root == null) {
            return true;
        }

        // 트리를 중위 순회(left -> root -> right)하여 검증
        // 왼쪽 서브트리 검증
        if(!isValidBST(root.left)) {
            return false;
        }

        // 중위 순회하고 있으므로 현재 노드는 항상 이전 값보다 커야함
        if(prev != null && prev >= root.val) {
            return false;
        }
        prev = root.val;

        // 오른쪽 서브트리 검증
        return isValidBST(root.right);
    }
}

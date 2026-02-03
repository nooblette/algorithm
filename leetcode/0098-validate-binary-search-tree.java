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
    public boolean isValidBST(TreeNode root) {
        // BST를 유지하기 위해서 각 노드가 속할 수 있는 범위 내에 있는지 검증
        return validRange(root, null, null);
    }

    private boolean validRange(TreeNode node, Integer min, Integer max) {
        if(node == null) {
            return true;
        }

        // 현재 노드가 BST를 유지하는 유효한 범위내에 있는지 검증
        if((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return validRange(node.left, min, node.val) && validRange(node.right, node.val, max);
    }
}

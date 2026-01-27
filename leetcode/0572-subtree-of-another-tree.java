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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 예외 처리
        if(root == null) {
            return false;
        }

        // tree와 subTree가 동일한 경우
        if(isSameTree(root, subRoot)) {
            return true;
        }

        // root의 자식 노드에 대해 탐색 반복
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        // 예외 처리
        if(node1 == null && node2 == null) {
            return true;
        }
        
        if(node1 == null || node2 == null) {
            return false;
        }

        // 두 node가 동일한지 확인
        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}

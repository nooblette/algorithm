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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 예외 처리
        if(root == null) {
            return 0;
        }
        
        // 노드 값이 high보다 크면 왼쪽 서브트리만을 탐색
        if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // 노드 값이 low보다 작으면 오른쪽 서브트리만을 탐색
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // 위 두 if문을 통과하고 여기에 도달 했으면 현재 노드의 값이 low와 high 사이에 있으므로 결과 반환
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
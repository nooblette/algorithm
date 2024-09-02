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
    // 자식 노드가 있는 동안 반복
    public int maxDepth(TreeNode root) {
        // 예외 처리
        if(root == null) {
            return 0;
        }

      // 왼쪽 자식 노드 탐색
      int left = maxDepth(root.left);

      // 오른쪽 자식 노드 탐색
      int right = maxDepth(root.right);

      // 왼쪽 자식 노드의 깊이와 오른쪽 자식 노드의 깊이 중 큰 값 반환
      return Math.max(left, right) + 1;
    }
}
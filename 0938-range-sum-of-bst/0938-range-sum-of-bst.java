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
        
        // 결과 변수
        int result = 0;
        
        // 현재 노드의 값이 low와 high 사이에 있다면 결과에 추가
        if(root.val >= low && root.val <= high) {
            result += root.val;
        }
        
        // 재귀 DFS
        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);
        
        return result;
    }
}
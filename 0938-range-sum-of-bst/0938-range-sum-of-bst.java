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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        
        // low가 root보다 크다면 root는 root의 오른쪽 자식으로 갱신
        if(low > root.val) {
            rangeSumBST(root.right, low, high);
        }
        
        // high가 root보다 작다면 root를 root의 왼쪽 자식으로 갱신
        else if(high < root.val) {
            rangeSumBST(root.left, low, high);
        }
        
        // low ≤ root ≤ high가 되면 아래 과정 진행
        else {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
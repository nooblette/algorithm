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
    public TreeNode invertTree(TreeNode root) {
        // 빈 노드에 도달하면 null 반환
        if(root == null) {
            return null;
        }
        
        // 현재 노드의 값을 복사한 신규 노드 생성
        TreeNode newNode = new TreeNode(root.val);
        
        // 왼쪽 자식 노드는 현재 노드의 오른쪽 자식 노드에 대해 재귀 DFS 진행
        newNode.left = invertTree(root.right);
        
        // 오른쪽 자식 노드는 현재 노드의 왼쪽 자신 노드에 대해 재귀 DFS 진행
        newNode.right = invertTree(root.left);
        
        // 추가한 신규 노드 반환
        return newNode;
    }
}
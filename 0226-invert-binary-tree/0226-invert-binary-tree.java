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
        // 예외 처리
        if(root == null) {
            return null;
        }
        
        // 반복 DFS를 위한 스택 선언
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 스택에 루트부터 삽입
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            // 왼쪽/오른쪽 노드 스왑
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            
            // 스택에 왼쪽 노드 추가
            if(node.left != null) {
                queue.add(node.left);
            }
            
            // 스택에 오른쪽 노드 추가
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        
        return root;
    }
}
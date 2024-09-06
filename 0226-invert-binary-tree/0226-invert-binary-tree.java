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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // bfs 탐색
        while(!q.isEmpty()) {
            int qSize = q.size();
            
            // 현재 레벨의 너비만큼 반복
            for(int i = 0; i < qSize; i++) {
                TreeNode node = q.remove();
                
                // 예외 처리
                if(node == null) {
                    continue;
                }
                
                // 왼쪽 노드와 오른족 노드를 뒤집는다.
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                
                // 두 자식 노드를 queue에 삽입
                q.add(node.left);
                q.add(node.right);
            }
        }
        
        return root;
    }
}
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
        // 반복 구조 BFS 구현을 위한 큐 선언
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 루트 노드 큐에 삽입
        queue.add(root);
        
        // 결과 변수 선언
        int result = 0;
        
        // BFS 탐색
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            // 노드 값이 low보다 크면 왼쪽 자식 노드에 대해서 DFS 탐색을 위해 스택에 추가
            if(node.val >= low && node.left != null) {
                queue.add(node.left);
            }
            
            // 노드 값이 high보다 작으면 오른쪽 자식 노드에 대해서 DFS 탐색을 위해 스택에 추가
            if(node.val <= high && node.right != null) {
                queue.add(node.right);
            }
            
            // 노드의 값이 low와 high 사이에 속하면 결과에 누적
            if(low <= node.val && node.val <= high) {
                result += node.val;
            }
        }
        
        return result;
        
    }
}
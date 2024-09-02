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
    public int maxDepth(TreeNode node) {
        // 예외 처리
        if(node == null) {
            return 0;
        }
        
        // BFS를 위한 큐 선언, Queue는 인터페이스이므로 구현체로 LinkedList를 사용한다.
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;        

        // root 노드를 큐에 삽입
        queue.add(node);
        
        // 큐가 모두 비워질 때까지 반복
        while(!queue.isEmpty()) {
            // 반복할때마다 깊이 + 1
            depth += 1;

            // 큐 크기 계산, BFS 탐색이므로 이 값은 해당 깊이의 모든 노드 수와 일치한다.
            int q_size = queue.size();

            // 해당 깊이에 위치한 모든 노드 수만큼 반복
            for(int i = 0; i < q_size; i++) {
                // 가장 먼저 삽입된 노드(가장 왼쪽)부터 추출된다.
                TreeNode cur = queue.poll();

                // 왼쪽 자식 노드가 있다면 큐에 삽입
                if(cur.left != null) {
                    queue.add(cur.left);
                }

                // 오른쪽 자식 노드가 있다면 큐에 삽입
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        	
        // BFS 반복 횟수 == 최대 깊이
        return depth;
    }
}
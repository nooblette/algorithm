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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 예외 처리
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isReverse = false;
        while(!queue.isEmpty()) {        
            // Zigzag를 양방향에서 삽입이 가능한 Deque으로 구현    
            Deque<Integer> deque = new ArrayDeque<>();

            // 레벨별 탐색
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    // 역순 여부에 따른 양방향 삽입
                    if(isReverse) {
                        deque.addFirst(node.val);
                    } else {
                        deque.addLast(node.val);
                    }

                    if(node.left != null) {
                        queue.offer(node.left);
                    }

                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            if(!deque.isEmpty()) {
                result.add(new ArrayList<>(deque));
            }

            // Zigzag를 위함
            isReverse = !isReverse;
        }

        return result;
    }
}

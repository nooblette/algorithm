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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 예외 처리
        if(root == null) {
            return result;
        }

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 현재 레벨에서의 노드만 탐색하기 위해 큐에 있는 노드의 개수만큼만 탐색
            int size = queue.size();

            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if(cur.left != null) {
                    queue.offer(cur.left);
                }

                if(cur.right != null) {
                    queue.offer(cur.right);
                }

                nodes.add(cur.val);
            }
            
            result.add(nodes);
        }

        return result;
    }
}

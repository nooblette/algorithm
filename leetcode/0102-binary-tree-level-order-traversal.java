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
        // 예외 처리
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // BFS Queue
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 레벨별 구분을 위한 자식 노드 Queue
        Deque<TreeNode> childQueue = new ArrayDeque<>();

        // BFS
        queue.addLast(root);
        result.add(List.of(root.val));
        while(!queue.isEmpty()) {
            // 레벨별 구분을 위해 현재 노드의 자식 노드들을 자식 노드 Queue에 삽입
            while(!queue.isEmpty()) {
                TreeNode cur = queue.removeFirst();
                if(cur.left != null) {
                    childQueue.addLast(cur.left);
                }

                if(cur.right != null) {
                    childQueue.addLast(cur.right);
                }
            }

            // 현재 노드의 모든 자식 노드들을 탐색했다면 자식 노드 Queue에서 BFS Queue로 이동
            List<Integer> nodes = new ArrayList<>();
            while(!childQueue.isEmpty()) {
                TreeNode child = childQueue.removeFirst();
                nodes.add(child.val);
                queue.addLast(child);
            }

            if(!nodes.isEmpty()) {
                result.add(nodes);
            }
        }

        return result;
    }
}

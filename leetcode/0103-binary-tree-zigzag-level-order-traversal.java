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
        result.add(List.of(root.val));

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isReverse = true;
        while(!queue.isEmpty()) {            
            List<Integer> list = new ArrayList<>();

            // 레벨별 탐색
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                addListAndQueue(node.left, list, queue);
                addListAndQueue(node.right, list, queue);
            }

            // 역순 여부에 따라 리스트를 뒤집어서 추가
            if(isReverse) {
                Collections.reverse(list);
            }
            if(!list.isEmpty()) {
                result.add(list);
            }

            // Zigzag를 위함
            isReverse = !isReverse;
        }

        return result;
    }

    private void addListAndQueue(TreeNode node, List<Integer> list, Deque<TreeNode> queue) {
        if(node == null) {
            return;
        }

        list.add(node.val);
        queue.offer(node);
    }
}

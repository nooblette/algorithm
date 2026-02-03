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
    public boolean isValidBST(TreeNode root) {
        // 트리를 중위 순회(left -> root -> right)하여 검증, 단 재귀가 아닌 스택을 활용
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        Integer prev = null;

        while(cur != null || !stack.isEmpty()) {
            // 가장 왼쪽 서브트리로 이동
            while(cur != null) {
                stack.offer(cur);
                cur = cur.left;
            }

            // BST를 만족하는지 확인, 중위 순회 중이므로 이전에 현재 val보다 큰 값이 존재해선 안된다.
            TreeNode node = stack.pollLast();
            if(prev != null && prev >= node.val) {
                return false;
            }
            prev = node.val;

            // 오른쪽 서브트리 탐색을 위함
            if(node.right != null) {
                cur = node.right;
            }
        }

        return true;
    }
}

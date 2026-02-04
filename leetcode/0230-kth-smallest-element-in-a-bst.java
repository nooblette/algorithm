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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        // BST를 중위 순회하면 오름차순으로 노드를 방문할 수 있다.
        while(cur != null || !stack.isEmpty()) {
            // 가장 왼쪽 자식 노드로 이동
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 현재 스택에는 탐색에 남은 노드 중 가장 작은 값이 상단에 있으므로 꺼내고 k번째 작은 원소인지 비교한다.
            cur = stack.pop();
            if(k == 1) {
                return cur.val;
            }
            k--;

            // 다시 오른쪽 자식 노드에 대해서 반복한다.
            cur = cur.right;
        }

        // 예외 처리
        return root.val;
    }
}

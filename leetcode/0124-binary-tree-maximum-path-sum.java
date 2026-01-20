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
    private int result = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        /* 
        최대 값이 가능한 후보 갱신
        1. 자기 자신만 택하는 경우
        2. 자기 자신과 왼쪽 자식을 택하는 경우
        3. 자기 자신과 오른쪽 자식을 택하는 경우
        4. 자기 자신과 왼쪽 자식과 오른쪽 자식 모두 택하는 경우
        */
        int left = dfs(node.left);
        int right = dfs(node.right);

        result = Math.max(result, node.val);
        result = Math.max(result, left + node.val);
        result = Math.max(result, node.val + right);
        result = Math.max(result, left + node.val + right);

        // 한 번 방문한 노드는 재방문할 수 없다. 따라서 현재 노드는 부모 노드에게 왼쪽 자식과 오른쪽 자식 중 합이 큰 경우를 택해 반환한다.
        // 만약 현재 값을 포함한 경로가 음수인 경우 현재 경로는 최대값 탐색에서 제외(0을 반환)한다.
        return Math.max(0, Math.max(left, right) + node.val);
    }
}

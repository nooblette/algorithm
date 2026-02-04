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
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        // BST를 중위 순회하면 노드를 오름차순 정렬한 순서대로 방문할 수 있다.
        // 단, 재귀로 중위 순회를 구현한다.
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        // 예외 처리
        if(node == null) {
            return;
        }

        // 가장 왼쪽 서브트리로 이동
        inorder(node.left, k);

        // k번째 작은 원소인지 판별
        count++;
        if(count == k) {
            result = node.val;
            return;
        }

        // 오른쪽 서브트리에 대해 반복
        inorder(node.right, k);
    }
}

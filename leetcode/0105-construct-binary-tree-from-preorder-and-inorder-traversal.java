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
    // root의 값이 inorder에서 등장하는 인덱스를 O(1)로 탐색하기 위함
    // inorder 배열에서 특정 값이 등장하는 인덱스를 Map에 저장
    private Map<Integer, Integer> map = new HashMap<>();

    // 현재 탐색 중인 preorder에서의 root를 저장
    private int rootIndexAtPreorder = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length);
    }

    // 핵심) 배열 자체를 넘기는 것이 아닌 인덱스만 넘겨 공간복잡도를 O(n)(Map 선언)으로 개선한다.
    public TreeNode buildTree(int[] preorder, int left, int right) {
        // 예외 처리
        if(left >= right) {
            return null;
        }

        // preorder는 root -> left -> right 순서로 탐색하므로 preorder[rootIndexAtPreorder]가 현재 탐색중이 노드의 root
        int root = preorder[rootIndexAtPreorder++];
        TreeNode node = new TreeNode(root);

        // 왼쪽 서브트리와 오른쪽 서브트리의 크기는 같다는 점을 이용해 해당 인덱스를 기준으로 왼쪽과 오른쪽으로 나누어 반복
        node.left = buildTree(preorder, left, map.get(root));
        node.right = buildTree(preorder, map.get(root) + 1, right);

        return node;
    }
}

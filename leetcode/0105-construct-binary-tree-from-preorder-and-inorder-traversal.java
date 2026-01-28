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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 전위 순회(preorder)의 첫 원소는 항상 루트
        TreeNode root = new TreeNode(preorder[0]);

        // 전위 순회(preorder)의 첫 원소를 기준으로 중위 순회(inorder)를 분할
        int index = getIndex(inorder, preorder[0]);

        // 중위 순회(inorder)를 root의 index로 분할하면 왼쪽은 left child, 오른쪽은 right child가 된다.
        int[] left = Arrays.copyOfRange(inorder, 0, index);
        int[] right = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // 중위 순회(inorder)를 분할하여 얻은 left와 right 배열의 길이를 기반으로 preorder도 left child와 right child로 분할한다.
        // 두 배열에 대해 다시 반복하여 왼쪽과 오른쪽 자식을 연결한다.
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, left.length + 1), left);
        root.right = buildTree(Arrays.copyOfRange(preorder, left.length + 1, preorder.length), right);

        return root;
    }

    // 정수형 배열 inorder에서 특정 원소 val에 해당하는 인덱스 찾기
    private int getIndex(int[] inorder, int val) {
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }
}

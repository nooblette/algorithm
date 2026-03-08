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
        if(preorder.length == 0) {
            return null;
        }
        
        // preorder: root -> left -> right
        // inorder: left -> root -> right
        TreeNode root = new TreeNode(preorder[0]);

        // root의 값이 inorder에서 등장하는 인덱스 탐색
        int rootIndex = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }

        // 왼쪽 서브트리와 오른쪽 서브트리의 크기는 같다는 점을 이용해 해당 인덱스를 기준으로 왼쪽과 오른쪽으로 나누어 반복
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));

        return root;
    }
}

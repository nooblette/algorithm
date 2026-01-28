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
        // preorder의 첫번째 원소(preorderIndex)를 루트로 삼고 이를 기준으로 inorder를 분할하여 왼쪽 서브트리와 오른쪽 서브트리를 탐색
        // preorder의 첫번째 원소의 값(preorder[preorderIndex])에 해당하는 inorder의 인덱스를 O(1)로 찾기 위해 map을 선언
        Map<Integer, Integer> indexByVal = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexByVal.put(inorder[i], i);
        }

        return buildTree(preorder, indexByVal, 0, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> indexByVal, int preorderIndex, int left, int right) {
        if(left >= right) {
            return null;
        }
        
        // 전위 순회(preorder)의 첫 원소는 항상 루트
        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);

        // root에 해당하는 중위 순회(inorder)의 인덱스 확인
        int index = indexByVal.get(rootVal);

        // 중위 순회 배열(inorder)에서 root의 index를 기준으로 인덱스 왼쪽 서브트리와 오른쪽 서브트리를 분할하여 탐색 반복
        root.left = buildTree(preorder, indexByVal, preorderIndex + 1, left, index);

        // 오른쪽 서브트리에서 preorderIndex는 왼쪽 서브트리의 크기(index - left)만큼 건너 뛴 인덱스에서 + 1을 취해야한다.
        root.right = buildTree(preorder, indexByVal, preorderIndex + index - left + 1 , index + 1, right);

        return root;
    }
}

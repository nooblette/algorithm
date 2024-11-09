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
    public TreeNode dfs(
        int preIndex, // 전위 순회 배열의 인데스(preorder[preIndex] 값이 현재 탐색중인 트리의 최상위 노드가 된다.)
        int inStart, int inEnd, int[] preorder, int[] inorder) {
        // 예외 처리
        if(preIndex > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        // 전위 순회 값이 중위 순회에서는 몇번째 인덱스인지 추출
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preIndex]) {
                inIndex = i;
            }
        }
        
        // 전위 순회 값을 갖는 inOrder 배열의 인덱스는 중위 순회 배열을 분할하는 기준 노드가 된다.
        TreeNode node = new TreeNode(inorder[inIndex]);
        
        // 전위 순회 다음 결과를 보도록 1 증가
        preIndex++;
        
        // 전위 순회 값을 갖는 inOrder 배열의 인덱스를 기준으로 왼쪽은 왼쪽 서브트리, 오른쪽은 오른쪽 서브트리가 된다.
        node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);
        node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 재구 DFS 진행, 초기 값은 전위 순회 인덱스: 0, 중위 순회 시작 인덱스: 0, 종료: 길이 - 1
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
}
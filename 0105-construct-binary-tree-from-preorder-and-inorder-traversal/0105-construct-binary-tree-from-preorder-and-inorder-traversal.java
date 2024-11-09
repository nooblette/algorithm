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
    private TreeNode dfs(List<Integer> preOrder, List<Integer> inOrder) {
        // 예외 처리
        if(inOrder.isEmpty()) {
            return null;
        }
        
        // 전위 순회 값이 중위 순회에서는 몇번째 인덱스인지 추출
        int inIndex = inOrder.indexOf(preOrder.get(0));
        
        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정
        TreeNode node = new TreeNode(inOrder.get(inIndex));
        
        // 왼쪽 서브트리에 대해 반복 - preOrder[1..inIndex], inOder[0..inIndex - 1]
        node.left = dfs(preOrder.subList(1, inIndex + 1), inOrder.subList(0, inIndex));
        
        // 오른쪽 서브트리에 대해 반복
        node.right = dfs(preOrder.subList(inIndex + 1, preOrder.size()), inOrder.subList(inIndex + 1, inOrder.size()));
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 원시형을 참조형으로 처리하기 위해 변수 선언
        List<Integer> preOrder = Arrays.stream(preorder)
                .boxed()
                .collect(Collectors.toList());
        
        List<Integer> inOrder = Arrays.stream(inorder)
                .boxed()
                .collect(Collectors.toList());

        
        // 재귀 DFS 진행, 리스트로 처리하면 파라미터가 간결해진다.
        return dfs(preOrder, inOrder);
    }
}
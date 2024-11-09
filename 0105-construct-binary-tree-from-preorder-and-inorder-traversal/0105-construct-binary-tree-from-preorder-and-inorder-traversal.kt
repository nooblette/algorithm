/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // 예외 처리
        if(inorder.isEmpty()) return null
        
        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스인지 추출
        val inIndex = inorder.indexOf(preorder[0])
        
        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정
        val node = TreeNode(inorder[inIndex])
        
        // 왼쪽 서브트리에 대해 반복
        node.left = buildTree(preorder.copyOfRange(1, inIndex + 1), inorder.copyOfRange(0, inIndex))
        
        // 오른쪽 서브트리에 대해 반복
        node.right = buildTree(preorder.copyOfRange(inIndex + 1, preorder.size), inorder.copyOfRange(inIndex + 1, inorder.size))
        
        return node;
    }
}
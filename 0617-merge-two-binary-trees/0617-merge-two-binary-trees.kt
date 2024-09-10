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
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        // 한쪽 노드가 null이면 null이 아닌 노드를 반환한다.
        if(root1 == null) return root2
        if(root2 == null) return root1
        
        // 병합된 노드 생성
        val node = TreeNode(root1.`val` + root2.`val`)
        
        // 기존 노드에 대해 DFS 진행, 병합된 노드의 자식 노드로 세팅
        node.left = mergeTrees(root1.left, root2.left)
        node.right = mergeTrees(root1.right, root2.right)
        
        // 병홥된 노드 리턴
        return node
    }
}
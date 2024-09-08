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
    fun invertTree(root: TreeNode?): TreeNode? {
        // 빈 노드 예외 처리
        if(root == null) {
            return root
        }
        
        // 왼쪽/오른쪽 자식 노드 스왑
        root.left = root.right.also {root.right = root.left}
        
        invertTree(root.left)   // 왼쪽 자식 노드 dfs
        invertTree(root.right)  // 오른쪽 자식 노드 dfs
        
        return root
    }
}
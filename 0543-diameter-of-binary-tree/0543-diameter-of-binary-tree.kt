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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var longest = 0
        
        fun dfs(node: TreeNode?): Int {
            // 리프노드 예외 처리
            if(node == null) {
                return -1
            }
            
            // 왼쪽과 오른쪽 노드의 상탯값 계산
            val left = dfs(node.left)
            val right = dfs(node.right)
            
            // 가장 긴 경로 계산
            longest = Math.max(longest, left + right + 2)
            
            // 상탯값 반환
            return Math.max(left, right) + 1
        }
        
        // 재귀 dfs 시작
        dfs(root)
        return longest
    }
}
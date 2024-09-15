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
    fun isBalanced(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?): Int {
            // 예외 처리
            if(node == null) {
                return 0
            }
            
            // 재귀 dfs로 왼쪽 리프 노드까지 탐색
            val left = dfs(node.left)
            
            // 재귀 dfs로 오른쪽 리프 노드까지 탐색
            val right = dfs(node.right)
            
            // 높이 균형이 아닌 경우 -1 반환
            return if(left == -1 || right == -1 || abs(left - right) > 1) 
                -1
            else 
                // 현재 노드의 높이 반환
                left.coerceAtLeast(right) + 1
        }
        
        // 반환 값이 -1이라면 균형이 깨졌으므로 false를 반환한다. 아니라면 true를 반환한다.
        return dfs(root) != -1
    }
}
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
    fun longestUnivaluePath(root: TreeNode?): Int {
        var answer = 0
        
        fun dfs(node: TreeNode?, parentVal: Int): Int {
            // 리프 노드이거나 예외 처리
            if(node == null) {
                return 0
            }
            
            // 왼쪽 자식 노드 탐색, 왼쪽 자식 노드의 동일한 값 경로 저장
            val left = dfs(node.left, node.`val`)
            
            // 오른쪽 자식 노드 탐색, 오른쪽 자식 노드의 동일한 값 경로 저장
            val right = dfs(node.right, node.`val`)
            
            // 최대 경로 값 갱신
            answer = Math.max(answer, left + right)
            
            // 현재 노드의 값이 부모 노드의 값과 동일한 경우 - 경로 길이에 + 1하여 반환
            if(node.`val` == parentVal) {
                return Math.max(left, right) + 1
            }
            
            return 0
        }
        
        dfs(root, -1)
        return answer
    }
}
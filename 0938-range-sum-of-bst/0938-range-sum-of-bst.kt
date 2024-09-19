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
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        // 예외 처리
        if(root == null) return 0
        
        // root의 값이 low보다 작은 경우 오른쪽 하위 노드만 탐색
        if(root.`val` < low) return rangeSumBST(root.right, low, high)
        
        // root의 값이 high보다 큰 경우 왼쪽 하위 노드만 탐색
        if(root.`val` > high) return rangeSumBST(root.left, low, high)
        
        // root의 값이 low와 high사이에 속하는 경우 누적 합 계산
        return root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) 
    }
}
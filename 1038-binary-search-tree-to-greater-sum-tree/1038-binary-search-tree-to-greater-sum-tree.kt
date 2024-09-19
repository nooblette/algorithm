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
    // 각 노드의 값(트리를 탐색하면서 구한 최대 값)을 저장
    var `val` = 0
    
    fun bstToGst(root: TreeNode?): TreeNode? {
        // 예외 처리
        if(root == null) return root
        
        // 오른쪽 자식 노드부터 탐색
        bstToGst(root.right)
        
        // 노드의 값을 val에 누적
        `val` += root.`val`
        
        // 노드 값 업데이트
        root.`val` = `val`
        
        // 왼쪽 자식 노드도 탐색
        bstToGst(root.left)
        
        return root
    }
}
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
    fun minDiffInBST(root: TreeNode?): Int {
        // 이전 노드의 값, 가장 작은 수로 설정
        var prev = Int.MIN_VALUE + 1000000
        
        // 노드간 차이 최솟값, 가장 큰 수로 설정
        var minDiff = Int.MAX_VALUE
        
        // 반복 구조 DFS 구현을 위한 스택 선언
        val stack: Deque<TreeNode> = LinkedList()
        var node = root
        
        // 스택이 비어있거나 node가 null이 될 때 까지 반복
        while(!stack.isEmpty() || node != null) {
            // 왼쪽 자식 노드를 모두 스택에 push
            while(node != null) {
                stack.add(node)
                node = node.left
            }
            
            // 스택에서 노드 추출
            node = stack.removeLast()
            
            // 현재 노드 값과 이전 노드 값의 차이를 구하고 최솟값이면 갱신
            minDiff = Math.min(minDiff, node.`val` - prev)
            // 현재 노드 값을 이전 노드 값으로 설정
            prev = node.`val`
            
            // 오른쪽 자식 노드를 node로 지정
            node = node.right
        }
        
        return minDiff
    }
}
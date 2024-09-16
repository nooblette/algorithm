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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun construct(lo: Int, hi: Int): TreeNode? {
            // 예외 처리
            if(lo > hi) return null
            
            // 인덱스의 중앙값 계산, 소수점 버림
            val mid = (lo + hi) / 2
            
            // 배열의 중앙 값으로 노드 생성
            val node = TreeNode(nums[mid])
            
            // 왼쪽 자식 노드는 배열 앞부분의 중앙 값
            node.left = construct(lo, mid - 1)
            
            // 오른쪽 자식 노드는 배열 뒷부분의 중앙 값
            node.right = construct(mid + 1, hi)
            
            return node;
        }
        
        // 예외 처리와 함께 결과 반환
        return if(nums.isEmpty()) null 
        else
            // 배열 전체를 넘겨서 트리 생성 시작
            construct(0, nums.size - 1)
    }
}
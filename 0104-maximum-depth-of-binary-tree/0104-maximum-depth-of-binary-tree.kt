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
    fun maxDepth(root: TreeNode?): Int {
        // 예외 처리
        if(root == null) {
            return 0
        }
        
        // BFS 진행을 위한 큐 선언, 큐는 인터페이스이며 자료형은 LinkedList 사용
        val queue: Queue<TreeNode> = LinkedList()
        
        // root 노드 삽입
        queue.add(root)
        
        // 결과로 반환할 깊이 변수 선언
        var depth = 0
        
        // 큐가 모두 비워질때까지 반복
        while(!queue.isEmpty()) {
            // 깊이 1 증가
            depth += 1
            
            // 큐 크기 계산, q_size는 현재 레벨에 존재하는 노드의 개수에 해당한다.
            val q_size = queue.size
            
            // 현재 레벨에 존재하는 노드 개수만큼 반복
            for(i in 0 until q_size) {
                val cur = queue.poll()
                
                // 왼쪽 자식 노드가 있다면 큐에 추가
                if(cur.left != null) {
                    queue.add(cur.left)
                }
                
                // 오른쪽 자식 노드가 있다면 큐에 추가
                if(cur.right != null) {
                    queue.add(cur.right)
                }
            }
        }
        
        // while 반복 횟수 == 트리의 최대 깊이
        return depth
    }
}
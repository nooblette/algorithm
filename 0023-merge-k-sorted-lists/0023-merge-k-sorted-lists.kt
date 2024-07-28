/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode> {o1, o2 -> 
            when {
                o1.`val` == o2.`val` -> 0
                o1.`val` > o2.`val` -> 1
                else -> -1
            }
        }
        
        val root = ListNode(0)
        var tail = root
        
        // 각 연결리스트의 첫번째 노드를 큐에 저장
        for(node in lists) 
            if(node != null)
                pq.add(node)
                
        // 큐가 모두 빌때까지 반복
        while(!pq.isEmpty()) {
            // 우선순위 따라 추출
            tail.next = pq.poll()
            tail = tail.next
            
            // 추출한 연결리스트의 다음 노드는 다시 큐에 저장
            if(tail.next != null) {
                pq.add(tail.next)
            }
        }
        
        return root.next
    }
}
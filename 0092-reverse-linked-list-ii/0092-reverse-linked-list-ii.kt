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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        // 예외 처리
        if(head == null) {
            return head
        }
        
        // 임시 노드 선언
        var root = ListNode(0)
        
        // 임시 노드 다음으로 노드 시작
        root.next = head
        
        // 임시 노드부터 시작해 변경이 필요한 위치(left) 앞으로 이동
        var start = root
        for(i in 0 until left - 1) {
            start = start.next
        }
        
        // 변경이 필요한 마지막 위치 선언
        var end = start.next
        
        // end가 right 위치로 갈때까지 뒤집기 반복
        for(i in 0 until right - left) {
            val tmp = start.next
            start.next = end.next
            end.next = end.next.next
            start.next.next = tmp
        }
        
        // 첫 번째 노드는 임시 노드이므로 그 다음부터를 결과로 반환
        return root.next
    }
}
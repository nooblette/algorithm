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
    fun insertionSortList(head: ListNode?): ListNode? {
        // 코틀린 함수의 파라미터는 val로 선언되어 수정할 수 없기 때문에 별도 변수에 할당한다.
        var head = head
        
        val parent = ListNode()
        
        // 정렬을 끝낸 연결리스트의 포인터 p
        var p = parent
        
        while(head != null) {
            // 정렬을 끝낸 리스트에 새로운 노드(head)를 삽입할 위치를 찾는다.
            while(p.next != null && p.next.`val` < head.`val`) {
                p = p.next
            }
            
            // 이미 정렬된 리스트에 head를 삽입한 뒤 붙여서 연결할 노드(p의 기존 순서 유지를 윟
            val pNext = p.next
            
            // head의 뒷 부분에 해당하는 노드, 삽입 후 head를 선언했던 임시변수로 갱신한다.
            val headNext = head.next
            
            // 이미 정렬된 리스트 중 적절한 위치에 head 삽입
            p.next = head
            head.next = pNext
            
            // head 갱신
            head = headNext
            
            // 정렬된 연결 리스트의 포인터(p)의 값보다 다음번 위치를 찾을 노드의 값이 작을 때만 포인터를 맨 앞으로 이동한다.
            // 즉 삽입 위치 탐색이 필요한 경우에만 포인터를 맨 앞으로 되돌아간다.
            if(head != null && p.`val` > head.`val`) {
                p = parent
            }
        }
        
        return parent.next
        
    }
}
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
    fun oddEvenList(head: ListNode?): ListNode? {
        // 에외 처리
        if(head == null) {
            return null
        }
        
        // 홀수 노드
        var odd: ListNode = head
        
        // 짝수 노드
        var even = head.next
        var evenHead = even
        
        // 리스트 순회
        while(even?.next != null) {
            odd.next = odd.next.next
            odd = odd.next
            
            even.next = even.next.next
            even = even.next
        }
        
        // 홀수 노드의 마지막 노드가 짝수 노드의 첫 노드를 가리키도록 연결
        odd.next = evenHead
             
        // 첫 번째 노드 반환
        return head
    }
}
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
    fun swapPairs(head: ListNode?): ListNode? {
        if(head?.next != null) {
            var p = head.next
            
            // 현재 노드의 다음 노드를 다음 -> 다음 노드로 변경
            head.next = swapPairs(head.next.next)
            
            // 현재 노드의 다음 노드가 다음 노드로 현재 노드를 가리키도록 변경
            p.next = head
            
            // 다음 노드를 반환
            return p;
        }
        
        return head
    }
}
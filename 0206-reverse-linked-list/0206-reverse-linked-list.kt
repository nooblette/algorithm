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
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var prev: ListNode? = null
        
        // 노드 끝으로 이동할때까지 순회
        while(node != null) {
            // 현재 노드의 다음 노드를 변수에 저장
            val next = node.next
            
            // 현재 노드의 다음 노드로 이전 노드 지정
            node.next = prev
            
            // 이전 노드를 현재 노드로 지정
            prev = node
            
            // 현재 노드를 저장해둔 다음 노드로 지정
            node = next
        }
        
        // prev는 뒤집힌 연결 리스트의 첫번째 노드
        return prev;
 
    }
}
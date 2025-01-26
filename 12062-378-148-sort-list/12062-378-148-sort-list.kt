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
    fun mergeTwoList(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null) return l2
        if(l2 == null) return l1
        
        // 코틀린의 메서드 파라미터는 기본적으로 val, 따라서 var 타입으로 재할당한다.
        var l1 = l1
        var l2 = l2
        
        // 앞 노드의 값이 더 크다면 스왑
        if(l1.`val` > l2.`val`) {
            l1 = l2.also{ l2 = l1 }
        }
        
        // 앞 노드의 다음 노드에 정렬하여 병합된 연결 리스트를 연결
        l1.next = mergeTwoList(l1.next, l2)
        return l1
    }
    
    fun sortList(head: ListNode?): ListNode? {
        // 연결 리스트를 단일 노드로 분할
        if(head?.next == null) return head
        
        // 러너 기법으로 중앙 노드 탐색
        var half: ListNode? = null
        
        // 중앙까지 가는 slow 러너는 널이 될 수 없다.
        var slow: ListNode = head
        
        // 끝까지 가는 fast 러너는 null이 될 수 있다.
        var fast: ListNode? = head
        
        while(fast?.next != null) {
            half = slow
            slow = slow.next
            fast = fast.next.next
        }
        
        // 중앙 노드를 기준으로 연결 리스트를 두 부분으로 분할
        half!!.next = null
        
        // 분할(divide) 재귀 호출, 각 노드는 더 이상 쪼갤 수 없는 단일 노드까지 분할된다.
        val l1 = sortList(head)
        val l2 = sortList(slow)
        
        // 정복(conquer), 단일 노드에 대해 정렬하여 병합하고 반환한다.
        return mergeTwoList(l1, l2)
    }
}
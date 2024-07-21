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
    fun isPalindrome(head: ListNode?): Boolean {
        val deque: Deque<Int> = LinkedList()
        
        // 연결리스트를 데크에 삽입
        var node = head
        while(node != null) {
            deque.add(node.`val`)
            node = node.next
        }
        
        // 데크가 모두 비거나 1개 이하가 될 때까지 비교
        while(!deque.isEmpty() && deque.size > 1) {
            // 데크의 양 끝을 추출해 팰린드롬 여부 확인
            if(deque.pollFirst() != deque.pollLast()) {
                return false
            }
        }
        
        return true
    }
}
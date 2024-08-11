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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // 코틀린의 함수 파라미터는 수정할 수 없으므로 변수(var)로 별도 선언
        var l1var = l1
        var l2var = l2
        
        // 값을 계산할 임시 노드 선언
        var node = ListNode(0)
        
        // 임시 노드를 첫번째 노드로 선언
        val root = node
        
        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        var sum: Int
        var carry = 0
        var remainder = 0
        
        // 두 연결리스트 l1과 l2를 끝까지 순회, 자리 올림수도 0이 될때까지 진행
        while(l1var != null || l2var != null || carry != 0) {
            sum = 0;
            
            // 첫 번째 연결리스트 합산 및 진행
            if(l1var != null) {
                sum += l1var.`val`
                l1var = l1var.next
            }
            
            // 두 번째 연결리스트 합산 및 진행
            if(l2var != null) {
                sum += l2var.`val`
                l2var = l2var.next
            }
            
            // 자리올림수와 나머지 계산
            remainder = (sum + carry) % 10
            carry = (sum + carry) / 10
            
            // 나머지 값을 현재 노드의 다음 노드로 지정
            node.next = ListNode(remainder)
            
            // 다음 노드로 이동
            node = node.next
        }
        
        // 첫번째 노드(root)는 임시노드, 따라서 다음 노드를 결과로 반환
        return root.next
        
    }
}
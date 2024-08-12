/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            ListNode p = head.next;
            
            // 현재 노드의 다음 -> 다음 노드를 파라미터로 전달하고 스왑된 값을 반환받는다.
            // 현재 노드의 다음 노드는 재귀 함수 반환한 값으로 변경한다.
            head.next = swapPairs(head.next.next);
            
            // 현재 노드의 다음 노드가 현재 노드를 가리키도록 변경한다.
            p.next = head;
            
            // 다음 노드를 반환한다.
            return p;
        }
        
        return head;
    }
}
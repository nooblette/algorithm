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
    public ListNode oddEvenList(ListNode head) {
        // 예외 처리
        if(head == null) {
            return null;
        }
        
        // 홀수 노드
        ListNode odd = head;
        
        // 짝수 노드
        ListNode even = head.next;
        ListNode evenHead = even;
        // 리스트 순회
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            
            even.next = even.next.next;
            even = even.next;
        }
        
        // 홀수 노드의 마지막 노드가 짝수 노드의 첫 노드를 가리키도록 연결
        odd.next = evenHead;
        
        // 첫 번째 노드 반환
        return head;
    }
}
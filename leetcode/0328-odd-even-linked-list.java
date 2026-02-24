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
        if(head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // 연결 리스트의 길이가 홀수인 경우 모든 노드를 탐색하면 even이 null로 끝난다.
        // 연결 리스트의 길이가 짝수인 경우 모든 노드를 탐색하면 even의 next가 null로 끝난다.
        // 연결 리스트의 모든 노드를 탐색하면 odd.next는 evenHead를 가리켜야한다.
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}

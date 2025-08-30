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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 노드를 가리키는 두 포인터 선언
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // first 포인터 먼저 연결 리스트의 n - 1번째 노드까지 이동
        for(int i = 0; i <= n; i++) {
            first = first.next;
        }

        // first 포인터가 null을 가리킬 때까지 first, second 포인터를 한 칸씩 이동
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second의 다음 노드(n번째 노드)를 n + 1번째 노드로 변경
        second.next = second.next.next;

        return dummy.next;
    }
}

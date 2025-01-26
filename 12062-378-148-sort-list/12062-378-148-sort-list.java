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
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        // 재귀 호출하여 병합한다. 둘 중 한 노드가 null이라면 다른 노드를 그대로 반환하여 이어붙인다.
        if(l2 == null) return l1;
        if(l1 == null) return l2;

        if(l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public ListNode sortList(ListNode head) {
        // 단일 노드를 찾을때까지 재귀 호출을 반복 (분할 정복)
        if(head == null || head.next == null) return head;

        // 중앙 값을 기준으로 연결리스트를 분할하기 위해 선언
        ListNode half = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            // 중앙 값 저장
            half = slow;

            slow = slow.next;
            fast = fast.next.next;
        }

        // 중앙 노드를 기준으로 연결 리스트를 분할
        half.next = null;

        // 분할된 두 연결리스트에 대해 반복
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 분할된 두 노드에 대해 병합한다.
        return mergeTwoList(l1, l2);
    }
}
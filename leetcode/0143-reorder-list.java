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
    public void reorderList(ListNode head) {
        // slow 러너와 fast 러너를 이용해 중점을 찾는다.
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 중점을 기준으로 후반부만 뒤집는다.
        ListNode second = slow.next;

        // 전반부와 분리
        slow.next = null; 

        // 후반부 뒤집기
        ListNode prev = null;
        while(second != null) {
            ListNode next = second.next;

            second.next = prev;
            prev = second;
            second = next;
        }

        // 전반부와 뒤집힌 후반부를 교대로 병합
        ListNode first = head;
        second = prev;

        while(second != null) {
            // 전반부의 다음 노드 저장
            ListNode temp1 = first.next;

            // 후반부의 다음 노드 저장
            ListNode temp2 = second.next;

            // 노드 병합
            first.next = second;
            first.next.next = temp1;

            // 다음 노드로 이동
            first = temp1;
            second = temp2;
        }
    }
}

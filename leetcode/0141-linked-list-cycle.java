/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 예외 처리
        if(head == null || head.next == null) {
            return false;
        }

        ListNode cur = head;
        while(cur != null) {
            // 방문한 노드 체크
            if(cur.val == Integer.MIN_VALUE) {
                return true;
            }

            // 방문한 노드 기록
            cur.val = Integer.MIN_VALUE;
            cur = cur.next;
        }

        return false;
    }
}

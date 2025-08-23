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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode tmp = cur.next;

            // 현재 노드의 다음 노드가 이전 노드를 가리키도록 변경
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
}

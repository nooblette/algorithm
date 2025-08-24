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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            // Slow Runner는 1칸씩 이동
            slow = slow.next;

            // Fast Runner는 2칸씩 이동
            fast = fast.next.next;

            // 두 러너가 만난다면 순환이 발생
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}

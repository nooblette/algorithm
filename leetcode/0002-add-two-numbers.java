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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode cur = root;

        // 올림 수 처리
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1) {
            // null 처리를 간결하게 개선
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            int sum = val1 + val2 + carry;

            // 두 노드 합 계산시 carry 처리 개선
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        return root.next;
    }
}

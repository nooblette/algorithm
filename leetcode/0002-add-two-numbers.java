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
        while(l1 != null || l2 != null) {
            int val1 = 0;
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            int val2 = 0;
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            
            int sum = val1 + val2 + carry;

            // 두 노드의 값이 두 자릿수라면 carry를 갱신하고 일의 자릿수만 사용한다.
            if(sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                // 두 노드의 값이 한 자릿수라면 carry를 초기화한다.
                carry = 0;
            }

            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        // 마지막 carry가 존재한다면 처리
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }

        return root.next;
    }
}

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode start = root;
        for(int i = 0; i < left -1; i++) {
            // 변경이 필요한 위치(left 노드)의 바로 앞까지 이동
            start = start.next;
        }
        ListNode end = start.next;
        
        for(
            int i = 0; 
            i < right - left; // end가 right 자리에 올때까지 반복
            i++
        ) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        
        // 첫번째 노드는 임시 노드이므로 그 다음 노드를 결과로 반환
        return root.next;
    }
}
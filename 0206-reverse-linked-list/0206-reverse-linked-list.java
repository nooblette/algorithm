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
        ListNode node = head, prev = null;
        while(node != null) {
            // 현재 노드의 다음 노드를 변수에 저장
            ListNode next = node.next;
            
            // 연결 리스트 뒤집기 : 현재 노드의 다음 노드를 이전 노드로 변경
            node.next = prev;
            
            // 다음 노드를 node로, 현재 노드를 prev로 변경하여 반복
            prev = node;
            node = next;
        }
        
        // prev는 뒤집힌 연결 리스트의 첫번째 노드
        return prev;
    }
}
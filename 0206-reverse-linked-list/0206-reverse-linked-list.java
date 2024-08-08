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
    private ListNode reverse(ListNode node, ListNode prev) {
        if(node == null) {
            return prev;
        }
        
        // 현재 노드의 다음 노드를 변수에 저장
        ListNode next = node.next;
        
        // 연결 리스트 뒤집기 : 현재 노드의 다음 노드를 이전 노드로 변경
        node.next = prev;
        
        // 다음 노드를 node로, 현재 노드를 prev로 전달하여 재귀 호출
        return reverse(next, node);
        
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}
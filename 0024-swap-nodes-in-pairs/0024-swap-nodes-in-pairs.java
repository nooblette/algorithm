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
    public ListNode swapPairs(ListNode head) {
        // 값을 계산할 임시 노드
        ListNode node = new ListNode(0);
        
        // 첫번째 노드를 임시 노드로 선언
        ListNode root = node;
        
        // 첫번째 노드의 다음 노드를 head 노드로 선언
        node.next = head;
        
        // 다음 노드와 다음 노드가 있는 동안 반복
        while(node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            
            // 연결 리스트의 연결 구조 변경
            a.next = b.next;
            node.next = b;
            b.next = a;
            
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        
        // 루트 노드는 임시 노디이므로 루트 노드의 다음 노드를 결과로 반환
        return root.next;
    }
}
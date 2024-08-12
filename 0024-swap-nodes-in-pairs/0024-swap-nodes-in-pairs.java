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
        // 스왑을 진행할 노드 선언
        ListNode node = head;
        
        // 현재 노드와 다음 노드가 진행하면 계속 반복
        while(node != null && node.next != null) {
            // 현재 노드와 다음 노드의 값을 스왑
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        
        // 첫번째 노드를 결과로 반환
        return head;
    }
}
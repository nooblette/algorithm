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
    private ListNode reverseList(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;
        
        while(cur != null) {
            // 연결리스트 뒤집기
            ListNode next = cur.next;
            
            // 연결 관계 변경
            cur.next = prev;
            
            // 다음 탐색을 위함
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {   
        if(head == null || head.next == null) {
            return;
        }
        
        // 중간 노드 찾기
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 중간 이후 리스트는 뒤집기
        ListNode tail = reverseList(slow.next);
        slow.next = null;
        
        // 두 리스트 병합
        ListNode first = head;
        while(tail != null) {
            ListNode next = first.next;
            ListNode prev = tail.next;

            first.next = tail;
            tail.next = next;

            first = next;
            tail = prev; 
        }
    }
}
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 전체 길이가 홀수인 경우
        if(fast != null) {
            slow = slow.next;
        }
        
        // 역순 연결 리스트 만들기
        ListNode rev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }
        
        // 역순 연결리스트와 입력값을 비교
        while(rev != null) {
            if(rev.val != head.val) {
                return false;
            }
            
            rev = rev.next;
            head = head.next;
        }
        
        return true;
    }
}
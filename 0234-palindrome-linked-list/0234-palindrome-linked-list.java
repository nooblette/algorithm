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
        // 스택 선언
        // 주의 : 스택을 이렇게 선언해선 안됨(자바 초기 자료형의 성능 문제)
        Stack<Integer> stack = new Stack<>();
        
        // 연결리스트를 스택에 삽입
        ListNode node = head;
        while(node != null) {
            stack.add(node.val);
            node = node.next;
        }
        
        // 연결 리스트가 모두 빌 때까지 비교
        while(head != null) {
            if(head.val != stack.pop()) {
                return false;
            }
            
            head = head.next;
        }
        
        return true;
    }
}
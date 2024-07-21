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
        Deque<Integer> deque = new LinkedList<>();
        
        // 연결리스트를 데크에 삽입
        ListNode node = head;
        while(node != null) {
            deque.add(node.val);
            node = node.next;
        }
        
        // 데크가 모두 비거나(길이가 짝수인 경우) 1개 이하(길이가 홀수인 경우)가 될 때까지 비교
        while(!deque.isEmpty() && deque.size() > 1) {
            if(deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        
        return true;
    }
}
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
        // 합한 결과 저장을 연결하기 위해 선언
        ListNode root = new ListNode();
        
        // 정답 반환을 위해 선언
        ListNode answer = root;
        
        int carry = 0;
        while(!(l1 == null && l2 == null)) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            // carry 초기화
            carry = 0;
            
            // 합한 결과가 10보다 큰 경우
            if(sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            
            // 정답 리스트에 추가
            root.next = new ListNode(sum);
            
            // 다음 노드로 탐색 진행
            if(l1 != null) l1 = l1.next;
            
            // 다음 노드로 탐색 진행
            if(l2 != null) l2 = l2.next;
            
            // 다음 노드로 변경
            root = root.next;
        }
        
        // 만약 carry가 남아있다면 추가
        if(carry > 0) root.next = new ListNode(carry);
        
        // 정답 리스트에 추가했으므로 첫번째 원소의 다음 노드를 반환
        return answer.next;
    }
}
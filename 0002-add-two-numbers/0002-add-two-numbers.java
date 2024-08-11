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
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        
        // 임시 노드를 첫번째 노드로 선언
        ListNode root = node;
        
        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry = 0, remainder = 0;
        
        // 두 연결리스트 l1과 l2를 끝까지 순회, 자리 올림수도 0이 될때까지 진행
        while(l1 != null || l2 != null || carry != 0) {
            sum = 0;
            
            // 첫 번째 연결리스트 합산 및 진행
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            // 두 번째 연결리스트 합산 및 진행
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next; 
            }
            
            // 자리올림수와 나머지 계산
            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            
            // 나머지 값을 현재 노드의 다음 노드로 지정
            node.next = new ListNode(remainder);
            
            // 다음 노드로 이동
            node = node.next;
        }
        
        // 첫번째 노드(root)는 임시노드, 따라서 다음 노드를 결과로 반환
        return root.next;
        
    }
}
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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }
        
        // 임시 노드 선언
        ListNode root = new ListNode(0);
        
        // 임시 노드 다음으로 노드 시작
        root.next = head;
        ListNode prev = root;
        
        // 임시 노드부터 시작해 변경이 필요한 위치(left) 앞까지 이동
        for(int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // left 노드와 right 노드 찾기
        ListNode start = prev.next;
        ListNode end = start;
        for(int i = 0; i < right - left; i++){
            end = end.next;
        }
        
        // right 노드 이후 부분을 분리
        ListNode next = end.next;
        end.next = null;
    
        
        // left ~ right 구간 뒤집기
        prev.next = reverseList(start);
        
        // 뒤집힌 리스트의 마지막 부분을 다시 연결
        start.next = next;
        
        // 첫 번째 노드는 임시 노드이므로 그 다음부터를 결과로 리턴
        return root.next;
    }
}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;

        // 연결 리스트 탐색
        while(list1 != null && list2 != null) {
            // 오름차순을 유지하는 동안 연결
            if(list1.val <= list2.val) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
            }

            merged = merged.next;
        }

        // 남은 노드 연결
        merged.next = (list1 == null) ? list2 : list1;
        
        return head.next;
    }
}

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
    public ListNode insertionSortList(ListNode head) {
        ListNode parent = new ListNode();
        ListNode p = parent;

        while(head != null) {
            // head를 삽입할 위치 탐색
            while(p.next != null && p.next.val < head.val) {
                p = p.next;
            }

            // 이미 정렬된 리스트에 head를 삽입한 뒤 붙여서 연결할 노드(p의 기존 순서 유지를 윟
            ListNode pNext = p.next;

            // head의 뒷 부분에 해당하는 노드, 삽입 후 head를 선언했던 임시변수로 갱신한다.
            ListNode headNext = head.next;

            // 이미 정렬된 리스트 중 적절한 위치에 head 삽입
            p.next = head;
            head.next = pNext;

            // head 갱신
            head = headNext;

            // 정렬된 연결 리스트의 포인터(p)의 값보다 다음번 위치를 찾을 노드의 값이 작을 때만 포인터를 맨 앞으로 이동한다.
            // 즉 삽입 위치 탐색이 필요한 경우에만 포인터를 맨 앞으로 되돌아간다.
            if(head != null && p.val > head.val) {
						p = parent;
					}
        }
        
        return parent.next;
    }
}
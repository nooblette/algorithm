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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode();
        ListNode head = merged;

        while (true)  {
            // 모든 연결 리스트 중 최소값 탐색
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }

            // 모든 리스트를 병합했다면 (더 이상 탐색할 최소값이 없다면) 종료
            if(minIndex == -1) {
                break;
            }

            // 연결 리스트에 추가
            merged.next = lists[minIndex];
            merged = merged.next;

            // 최소값의 노드를 다음으로 이동
            lists[minIndex] = lists[minIndex].next;
        }      

        return head.next;
    }
}

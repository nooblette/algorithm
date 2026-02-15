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
        ListNode result = new ListNode();
        ListNode cur = result;

        while(true) {
            // lists에서 최소 원소 탐색
            ListNode min = null;
            int minIndex = 0;
            int nullCnt = 0;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                    nullCnt++;
                    continue;
                }

                if(min == null || lists[i].val < min.val) {
                    min = lists[i];
                    minIndex = i;
                }
            }

            // 모든 노드가 null을 가리킨다면 탐색 종료
            if(nullCnt == lists.length) {
                return result.next;
            }

            // 반환할 연결 리스트에 추가
            cur.next = min;
            cur = cur.next;

            // 최소 원소를 찾았다면 댜음 노드를 가리키도록 변경
            ListNode minNode = lists[minIndex];
            lists[minIndex] = minNode.next;
        }
    }
}

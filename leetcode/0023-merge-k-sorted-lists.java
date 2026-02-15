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
        // list의 각 원소들로 우선수위 큐 선언
        // ListNode는 Comparable의 하위 클래스가 아니므로 생성자에 Comparator를 직접 넘겨줘야한다.
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list != null) {
                pq.offer(list);
            }
        }

        // 우선순위 큐로 선언했으므로 가장 앞에 있는 원소가 최소 값을 갖는 노드 (최소 노드)
        ListNode result = new ListNode();
        ListNode cur = result;

        while(!pq.isEmpty()) {
            ListNode min = pq.poll();

            // 반환할 리스트에 연결
            cur.next = min;
            cur = cur.next;

            // 최소 노드의 다음노드를 다시 우선순위 큐에 추가
            if(min.next != null) {
                pq.offer(min.next);
            }
        }

        return result.next;
    }
}

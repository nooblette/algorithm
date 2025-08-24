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
        // 최소 힙 선언
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 주어진 연결 리스트의 첫번째 노드만 우선순위 큐에 삽입
        for(ListNode node : lists) {
            if(node != null) {
                pq.offer(node);
            }
        }

        // 우선순위 큐가 비어있을 때까지 원소를 꺼내어 연결리스트로 병합
        ListNode merged = new ListNode();
        ListNode head = merged;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            merged.next = node;
            merged = merged.next;

            // 만약 다음 노드가 있다면 다시 우선순위 큐에 삽입
            if(node.next != null) {
                pq.offer(node.next);
            }
        }

        return head.next;
    }
}

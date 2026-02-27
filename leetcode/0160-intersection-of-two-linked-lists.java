/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 연결 리스트 headA의 노드들을 HashSet에 저장 (일반적으로 조회 시간복잡도가 O(1))
        Set<ListNode> visited = new HashSet<>();
        while(headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        // 연결 리스트 headB의 노드들을 탐색하며 visited Set에 있는지 확인
        while(headB != null) {
            if(visited.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        // 교차지점이 없는 경우
        return null;
    }
}

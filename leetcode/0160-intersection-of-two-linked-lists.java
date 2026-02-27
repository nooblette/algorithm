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
        // 두 연결 리스트의 전체 길이 탐색
        int m = getLength(headA);
        int n = getLength(headB);

        // 두 연결 리스트 중 길이가 긴 노드는 두 연결 리스트의 길이 차이만큼 이동
        // 교차 지점을 찾기 위한 출발 지점을 동일하게 맞춘다.
        // 길이 차이를 이용해 출발 지점을 맞추어 탐색함으로써 공간 복잡도를 O(1)로 개선한다. (별도 방문 노드 기록 공간이 필요 없음)
        int diff = Math.abs(m - n);
        if(m > n) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            } 
        } else {
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        // 두 연결 리스트의 노드가 같은 힙 메모리 공간을 참조할때까지 반복
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // 두 연결 리스트가 같은 힙 메모리 공간을 참조(= 교차지점)하거나 연결 리스트 끝까지 이동해 null을 반환한다.
        return headA;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}

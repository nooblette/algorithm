/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        // 이전 노드 값, 오버 플로우를 방지하기 위해 10^5만큼 더하여 초기화
        int prev = Integer.MIN_VALUE + 100000;

        // 노드 간 차이 최솟 값, 가장 큰 수로 설정
        int minDiff = Integer.MAX_VALUE;
        
        // 반복 구조 DFS 구현을 위한 스택 선언
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        // 루트를 node 변수로 선언
        TreeNode node = root;
        
        // DFS 탐색 - 스택이 비어있거나 node가 null이 될 때 까지 반복
        while(!stack.isEmpty() || node != null) {
            // 왼쪽 자식 노드의 리프 노드까지 스택에 삽입
            while(node != null) {
                stack.add(node);
                node = node.left;
            }
            
            // 스택에서 노드 추출
            node = stack.removeLast();
          
            // 현재 노드 값과 이전 노드 값의 차이를 구하고 최솟값이라면 갱신
            // 항상 왼쪽 자식 -> 부모 -> 오른쪽 자식 순서로 방문하므로 node.val은 prev보다 크다.(차이로 음수가 나오는 경우가 없다.)
            minDiff = Math.min(minDiff, node.val - prev);
            
            // 현재 노드 값을 이전 노드 값으로 설정
            prev = node.val;
            
            // 오른쪽 자식 노드로 지정하여 반복
            node = node.right;
        }
        
        return minDiff;
    }
}
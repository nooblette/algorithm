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
    // 이전 노드 값, 오버 플로우를 방지하기 위해 10^5만큼 더하여 초기화
    int prev = Integer.MIN_VALUE + 100000;
    
    // 노드 간 차이 최솟 값, 가장 큰 수로 설정
    int minDiff = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        // 중위 탐색
        // 왼쪽 자식 노드 중 맨 아래 노드까지 탐색
        if(root.left != null) minDiffInBST(root.left);
        
        // 현재 노드 값과 이전 노드 값의 차이를 구하고 최솟값이라면 갱신
        // 항상 왼쪽 자식 -> 부모 -> 오른쪽 자식 순서로 방문하므로 root.val은 prev보다 크다.(차이로 음수가 나오는 경우가 없다.)
        minDiff = Math.min(minDiff, root.val - prev);
        
        // 현재 노드 값을 이전 노드 값으로 재설정
        prev = root.val;
        
        // 오른쪽 자식 노드 재귀 탐색
        if(root.right != null) minDiffInBST(root.right);
        
        return minDiff;
    }
}
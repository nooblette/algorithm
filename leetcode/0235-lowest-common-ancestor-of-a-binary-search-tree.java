/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 인덱스 비교 없이 주어진 트리 자체만으로 공통 조상을 판별한다, 단 재귀 호출하여 풀이한다.

        // p와 q가 현재 node 기준으로 왼쪽 서브트리에 있는 경우
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            // p와 q가 현재 node 기준으로 오른쪽 서브트리에 있는 경우
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // 현재 node가 공통 조상인 경우
            return root;
        }
    }
}

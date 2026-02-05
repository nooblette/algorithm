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
        // 인덱스 비교 없이 주어진 트리 자체만으로 공통 조상을 판별한다.
        TreeNode node = root;

        while(node != null) {
            int cur = node.val;

            // 현재 node 자체가 공통 조상인 경우
            if(cur == p.val || cur == q.val || cur > p.val && cur < q.val || cur > q.val && cur < p.val) {
                return node;
            } else if(cur > p.val && cur > q.val) {
                // p와 q가 현재 node 기준으로 왼쪽 서브트리에 있는 경우
                node = node.left;
            } else {
                // p와 q가 root 기준으로 오른쪽 서브트리 있는 경우
                node = node.right;
            }
        }

        return node;
    }
}

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
    private List<Integer> inorder = new ArrayList<>();
    private Map<Integer, Integer> valByIndex = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 주어진 트리를 중위 순회하여 배열 생성
        generateInorder(root);

        // key: node의 val, value: 해당 val이 등장하는 inorder 리스트에서의 인덱스
        for(int i = 0; i < inorder.size(); i++) {
            valByIndex.put(inorder.get(i), i);
        }

        // BST를 중위 순회하여 오름차순 정렬한 배열로 탐색하므로 left에 작은 값이 들어가야한다.
        return findAncestor(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    private TreeNode findAncestor(TreeNode node, int p, int q) {
        int cur = node.val;

        // 현재 node 자체가 공통 조상인 경우
        if(cur == p || cur == q || valByIndex.get(cur) > valByIndex.get(p) && valByIndex.get(cur) < valByIndex.get(q)) {
            return node;
        }

        // p와 q가 root 기준으로 왼쪽 서브트리에 있는 경우
        if(valByIndex.get(cur) > valByIndex.get(p) && valByIndex.get(cur) > valByIndex.get(q)) {
            return findAncestor(node.left, p, q);
        }

        // p와 q가 root 기준으로 오른쪽 서브트리 있는 경우
        return findAncestor(node.right, p, q);
    }

    private void generateInorder(TreeNode node) {
        if(node == null) {
            return;
        }

        generateInorder(node.left);
        inorder.add(node.val);
        generateInorder(node.right);
    }
}

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
    public boolean isValidBST(TreeNode root) {
        // 주어진 트리를 중위 순회        
        List<Integer> values = inorder(root);

        // 오름차순 정렬 여부 확인
        for(int i = 1; i < values.size(); i++) {
            if(values.get(i - 1) >= values.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> inorder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        // 리프 노드인 경우
        if(root.left == null && root.right == null) {
            return List.of(root.val);
        }

        // 왼쪽 서브트리 연결
        List<Integer> left = new ArrayList<>();
        if(root.left != null) {
            left = inorder(root.left);
        }

        // 오른쪽 서브트리 연결
        List<Integer> right = new ArrayList<>();
        if(root.right != null) {
            right = inorder(root.right);
        }

        // 원소 추가를 위해 깊은 복사
        List<Integer> values = new ArrayList<>(left);
        values.add(root.val);
        values.addAll(right);
        return values;
    }
}

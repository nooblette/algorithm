/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer("[");

        // null을 추가하기 위해 LinkedList로 구현
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if(cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        
        // sb의 마지막 문자가 ','일 때
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setCharAt(sb.length() - 1, ']'); // 마지막 ','를 ']'로 변경
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 예외 처리
        if("[]".equals(data)) {
            return null;
        }

        // 문자열을 값 배열로 변환
        String[] vals = data.substring(1, data.length() - 1).split(",");
        if("null".equals(vals[0])) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque();

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        for(int i = 1; !queue.isEmpty() && i < vals.length; i += 2) {
            TreeNode cur = queue.poll();

            // 왼쪽 자식 연결
            if(!"null".equals(vals[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                cur.left = left;
                queue.offer(left);
            }

            // 오른쪽 자식 연결
            if(!"null".equals(vals[i + 1])) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i + 1]));
                cur.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

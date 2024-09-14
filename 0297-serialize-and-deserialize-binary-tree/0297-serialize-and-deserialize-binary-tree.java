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
        // 예외 처리
        if(root == null) {
            return null;
        }

        // 반복 BFS 처리를 위한 큐 선언
        Queue<TreeNode> q = new LinkedList<>();

        // 큐에 루트부터 삽입
        q.add(root);

        // 직렬화 결과 변수 - 리턴 타입이 문자열에 계속 원소가 추가되는 형태이므로 StringBuilder로 선언한다.
        StringBuilder sb = new StringBuilder();

        // 0번 인덱스는 사용하지 않는다. 초기 값은 루트 노드의 값
        // 이때 사용하지 않는 인덱스거나 노드가 없는 인덱스(null)은 편의상 #(사용하지 않는 문자)로 표현한다.
        sb.append(String.valueOf("#," + root.val));

        // BFS 탐색
        while(!q.isEmpty()) {
            // 큐에서 노드 추출
            TreeNode node = q.remove();

            // 왼쪽 자식 노드가 null이 아니면 큐와 직렬화 결과 문자열에 삽입
            if(node.left != null) {
                q.add(node.left);
                sb.append("," + node.left.val);
            } else {
                // 왼쪽 자식 노드가 null이면 직렬화 결과에 # 삽입
                sb.append(",#");
            }

            // 오른쪽 자식 노드가 null이 아니면 큐와 직렬화 결과 문자열에 삽입
            if(node.right != null) {
                q.add(node.right);
                sb.append("," + node.right.val);
            } else {
                // 오른쪽 자식 노드가 null이면 직렬화 결과에 # 삽입
                sb.append(",#");
            }
        }

        // StringBuilder를 문자열로 변환하여 반환
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 예외 처리
        if(data == null) {
            return null;
        }
        
        // 콤마(,)를 기준으로 문자열 분리
        String[] nodes = data.split(",");
        
        // 인덱스 1번이 루트
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));

        // 직렬화와 동일하게 BFS로 역직렬화 처리 위한 큐 선언
        Queue<TreeNode> q = new LinkedList<>();

        // 큐에 루트부터 추가
        q.add(root);

        // 루트를 제외하고 2번 인덱스부터 진행
        int index = 2;

        while(!q.isEmpty()) {
            TreeNode node = q.remove();

            String val = nodes[index];

            // 해당 인덱스가 #이 아니면 왼쪽 자식 노드로 설정하고 큐에 추가
            if(!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.left);
            }

            // 항상 좌/우 세트로 구성되므로 한 번 더 진행
            index += 1;
            if(!nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.right);
            }

            index += 1;
        }

        // 결과 반환
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
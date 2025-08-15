/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Integer, Node>());
    }

    private Node dfs(Node node, Map<Integer, Node> visited) {
        if(node == null) {
            return node;
        }

        // 이미 방문한 노드인 경우
        if(visited.containsKey(node.val)) {
            // 복사한 노드를 반환한다.
            return visited.get(node.val);
        }

        Node copiedNode = new Node(node.val);

        // 방문 기록 표시
        visited.put(node.val, copiedNode);

        // 인접 노드 방문
        for(Node neighbor : node.neighbors) {
            copiedNode.neighbors.add(dfs(neighbor, visited));
        }

        return copiedNode;
    }
}

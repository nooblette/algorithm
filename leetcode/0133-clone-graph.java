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
        if(node == null) {
            return null;
        }

        // 방문한 노드 저장
        Map<Integer, Node> visited = new HashMap<>();
        Node copiedNode = new Node(node.val);
        visited.put(node.val, copiedNode);

        // BFS
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            // 인접 노드 탐색
            for(Node neighbor : current.neighbors) {
                
                // 처음 방문하는 경우
                if(!visited.containsKey(neighbor.val)) {
                    Node copiedNeighbor = new Node(neighbor.val);

                    // 방문 기록 저장
                    visited.put(neighbor.val, copiedNeighbor);

                    // 큐에 저장
                    queue.offer(neighbor);
                }
                // 이웃 관계 설정
                visited.get(current.val).neighbors.add(visited.get(neighbor.val));
            }
        }

        return copiedNode;
    }
}

import java.util.*;

class Solution {
    // from -> to 인접 리스트
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int answer = 1;

    static class Node {
        int index;
        int sheep;
        int wolves;
        List<Integer> nodes;

        Node(int index, int sheep, int wolves, List<Integer> nodes) {
            this.index = index;
            this.sheep = sheep;
            this.wolves = wolves;
            this.nodes = nodes;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        // from -> to 그래프 구성
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0, graph.get(0)));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            // 방문 가능한 노드 목록 탐색
            for(int nextNode : node.nodes) {
                // Node 클래스의 양의 수(sheep)와 늑대의 수(wolves)를 상태 갱신
                int nextSheep = (info[nextNode] == 0) ? node.sheep + 1 : node.sheep;
                int nextWolves = (info[nextNode] == 1) ? node.wolves + 1 : node.wolves;

                // 방문할 수 있다면
                if(nextSheep > nextWolves) {
                    // 최대값 갱신
                    answer = Math.max(answer, nextSheep);

                    // 기존 node.nodes를 유지(복사하여 새로운 객체 참조)하고 방문한 노드의 자식 노드를 추가
                    // 값에 의한 호출이 되도록 완전히 새로운 리스트를 복사하여 생성한다.
                    List<Integer> candidateNodes = new ArrayList<>(node.nodes);

                    // 현재 방문한 노드는 제외
                    candidateNodes.remove(Integer.valueOf(nextNode));

                    // 방문한 노드의 자식 노드를 추가
                    if(graph.get(nextNode) != null) {
                        candidateNodes.addAll(graph.get(nextNode));
                    }

                    // 큐에 삽입
                    queue.offer(new Node(nextNode, nextSheep, nextWolves, candidateNodes));
                }
            }
        }
        
        return answer;
    }
}
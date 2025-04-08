import java.util.*;

class Solution {
    int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        // 부모 - 자식 관계 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // 0번 노드부터 dfs 탐색 
        dfs(0, 0, 0, List.of(0), info, graph);
        
        return maxSheep;
    }
    
    private void dfs(int current, int sheep, int wolf, List<Integer> nextNodes, int[] info, List<List<Integer>> graph) {
        // 현재 노드 방문 - 양과 늑대의 수 갱신
        if(info[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        // 더 이상 진행할 수 없다면 현재 경로상 current 노드는 포기
        // 다른 노드에서 양을 더 얻고 나면 방문 가능할 수 있음
        if(sheep <= wolf) {
            return;
        }
        
        // 최대값 갱신
        maxSheep = Math.max(maxSheep, sheep);
        
        // 다음에 방문할 후보 리스트 갱신 -리스트를 수정하면 탐색 경로에 영향을 끼치므로(주소를 참조) 새로운 변수에 할당한다.
        // 기존에 방문 후보였던 노드(복사) + 현재 노드의 자식 노드를 추가(확장)
        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        
        // 현재 방문한 경로는 제외하고 자식 노드를 추가
        newNextNodes.remove(Integer.valueOf(current));
        newNextNodes.addAll(graph.get(current));
        
        // 자식 노드를 확장한 방문 후보 노드에 대해 탐색 반복
        for(int next : newNextNodes) {
            dfs(next, sheep, wolf, newNextNodes, info, graph);    
        }
    }
}
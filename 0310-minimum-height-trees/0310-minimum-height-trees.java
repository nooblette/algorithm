class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 예외 처리
        if(n == 1) {
            return List.of(0);
        }

        // 주어진 edges로 출발 노드 -> 도착 노드 목록을 구성하는 Map 구현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            // 값이 존재하지 않을 경우 빈 리스트 먼저 생성
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            // 그래프 구성
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 리프 노드 목록을 저장
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            // 연결이 하나인 노드를 리프 노드 목록에 추가
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 루트 노드만 남을때 까지 반복
        while(n > 2) {
            // 이전 단계 리프 노드 개수만큼 n에서 제거
            n -= leaves.size();

            // 단계별 새로운 리프 노드 목록 저장
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                // 리프 노드의 이웃 노드 추출
                int neighbor = graph.get(leaf).get(0); // 항상 이웃 노드는 1개

                // 이웃 노드에서 리프 노드까지의 연결 삭제
                // remove()에 매개변수로 leaf만 전달하면 인덱스를 제거한다.
                // 따라서 명시적으로 값을 기준으로 원소를 찾아 제거한다는 의미로 Object로 형변환한다.
                graph.get(neighbor).remove((Object) leaf);

                // 연결을 제거한 뒤 리프도느가 된다면 새로운 리프 노드 목록 변수에 추가
                if(graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            // 리프 노드 목록 리스트 갱신
            leaves = newLeaves;
        }

        // 노드가 2개 이하 남게 될 때 최종 결과 리턴
        return leaves;
    }
}
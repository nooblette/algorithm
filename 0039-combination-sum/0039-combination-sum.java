class Solution {
    public void dfs(List<List<Integer>> results, List<Integer> path, int[] candidates, int sum, int target, int start) {
        // 숫자 조합의 합이 target이 되는 경우 results에 추가
        if(sum == target) {
            results.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            
            // 원소의 합이 target보다 이미 큰 경우 탐색 미진행
            if(sum + c > target) {
                break;
            }
            
            // 조합 목록에 c 추가
            path.add(c);
            
            // dfs 재귀 호출
            // 현재 탐색을 진행중인 노드의 인덱스 i를 전달한다. (자식 노드는 이 i부터 탐색을 시작)
            dfs(results, path, candidates, sum + c, target, i);
            
            // c 제거
            path.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        // 배열 정렬
        Arrays.sort(candidates);
        
        // dfs 탐색 시작
        dfs(results, new LinkedList<>(), candidates, 0, target, 0);
        
        return results;
    }
}
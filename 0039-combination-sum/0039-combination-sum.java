class Solution {
    public void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {
        // 0보다 작다면 목표값을 넘었으므로 리턴
        if(target < 0) {
            return;
        }

        // 0이면 목표값에 도달했으므로 결과에 추가하고 리턴
        if(target == 0){
            // 이전 경로를 저장해둔 path를 결과에 삽입
            results.add(new ArrayList<>(path));
            return;
        }

        // 자기 자신보다 큰 숫자에 대해 dfs
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(results, candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 결과 저장 리스트 선언
        List<List<Integer>> results = new ArrayList<>();
        
        // dfs 탐색
        dfs(results, candidates, target, 0, new ArrayDeque<>());
        
        return results;
    }
}
class Solution {
    private void dfs(int[] candidates, List<Integer> path, int target, List<List<Integer>> answer, int start) {
        // 만약 target이 0보다 작다면 더 이상 합이 target이 되는 조합을 찾을 수 없으므로 탐색 종료
        if(target < 0) {
            return;
        }
        
        // 정답 조합을 찾은 경우
        if(target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, path, target - candidates[i], answer, i);
            path.remove(Integer.valueOf(candidates[i]));
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(candidates, new ArrayList<>(), target, answer, 0);
        return answer;
    }
}
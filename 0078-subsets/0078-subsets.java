class Solution {
    public void dfs(List<List<Integer>> results, int[] nums, List<Integer> path, int start) {
        // 부분집합을 results 변수에 추가
        results.add(new ArrayList<>(path));
        
        // 탐색 종료 조건
        if(path.size() == nums.length) {
            return;
        }
        
        // start부터 이후 인덱스에 대해서 탐색
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(results, nums, path, i + 1);
            path.removeLast();
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        // 정답을 저장할 변수
        List<List<Integer>> results = new ArrayList<>();    
        
        // dfs 탐색
        dfs(results, nums, new LinkedList<>(), 0);
        
        return results;
    }
}
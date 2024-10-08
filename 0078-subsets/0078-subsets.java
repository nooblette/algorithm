class Solution {
    public void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        // 모든 탐색 경로를 매번 결과에 추가
        results.add(new ArrayList<>(path));

        // 자기자신보다 큰 숫자를 dfs 진행
        for(int i = index; i < nums.length; i++) {
            // path에 현재 엘리먼트 추가
            path.add(nums[i]);

            // 재귀 dfs
            dfs(results, nums, i + 1, path);

            // 돌아온 이후 현재 엘리먼트 삭제
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        // 결과 저장 리스트
        List<List<Integer>> results = new ArrayList<>();
        
        // dfs 시작
        dfs(results, nums, 0, new ArrayDeque());
        
        return results;
    }
}
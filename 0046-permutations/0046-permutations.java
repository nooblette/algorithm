class Solution {
    private void dfs(List<Integer> path, List<List<Integer>> answer, int[] nums) {
        // 모든 숫자를 방문한 경우
        if(path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        // 각 원소에 대해 dfs 탐색 진행
        for(Integer num : nums) {
            // 이미 방문한 노드라면 다음 원소에 대해 탐색
            if(path.contains(num)) {
                continue;
            }
            
            path.add(num);
            dfs(path, answer, nums);
            path.remove(num);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // 결과를 담을 변수
        List<List<Integer>> answer = new ArrayList<>();
        
        // 방문한 경로
        List<Integer> path = new ArrayList<>();
        dfs(path, answer, nums);
        
        return answer;
    }
}
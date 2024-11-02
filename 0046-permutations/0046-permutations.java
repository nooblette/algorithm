class Solution {    
    private void dfs(Integer num, int[] nums, List<Integer> path, List<List<Integer>> answer) {
        
        // 이미 결과를 찾는데 사용한 숫자인 경우
        if(path.contains(num)) {
            return;
        }
        
        // DFS 탐색 깊이가 nums의 길이와 동일한 경우
        path.add(num);
        if(path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            path.remove(num);
            return;
        }
        
        for(int newNum : nums) {
            dfs(newNum, nums, path, answer);
        }
        path.remove(num);
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int num : nums) {
            dfs(num, nums, new ArrayList<>(), answer);
        }
        
        return answer;
    }
}
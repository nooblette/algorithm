class Solution {
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> answer, int k, int start) {
        if(path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for(int num : nums) {
            if(num > start) {
                path.add(num);
                dfs(nums, path, answer, k, num);
                path.remove(Integer.valueOf(num));
            }
        }
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        
        // 1부터 n까지 배열 선언
        int[] nums = new int[n];
        
        // 초기화
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
        dfs(nums, new ArrayList<>(), answer, k, 0);
        return answer;
    }
}
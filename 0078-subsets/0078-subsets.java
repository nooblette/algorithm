class Solution {
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> answer, int start) {
        answer.add(new ArrayList<>(path));
        
        for(int i = start; i < nums.length; i++) {
            int num = nums[i];
            
            if(!path.contains(num)) {
                path.add(num);
                dfs(nums, path, answer, i);
                path.removeLast();
            }
        }
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(nums, new ArrayList<>(), answer, 0);
        
        return answer;
    }
}
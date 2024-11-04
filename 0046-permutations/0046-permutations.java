class Solution {
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> answer) {
        if(path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for(int num : nums) {
            if(!path.contains(num)) {
                path.add(num);
                dfs(nums, path, answer);
                path.remove(Integer.valueOf(num));
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(nums, new ArrayList<>(), answer);
        
        return answer;
    }
}
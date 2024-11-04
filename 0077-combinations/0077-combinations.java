class Solution {
    private void dfs(List<Integer> path, List<List<Integer>> answer, int n, int k, int start) {
        if(path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = start; i < n; i++) {
            path.add(i + 1);
            dfs(path, answer, n, k, i + 1);
            path.remove(Integer.valueOf(i + 1));
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(new ArrayList<>(), answer, n, k, 0);
        return answer;
    }
}
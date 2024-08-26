class Solution {
    public void dfs(List<Integer> path, List<List<Integer>> results, int[] nums) {
        // 모든 숫자를 방문한 경우
        if(path.size() == nums.length) {
            // 방문한 경로를 새로운 변수로 선언하여 path에 추가
            // path를 바로 추가하면 참조값이 추가되어 for loop 종료시 비어있는 리스트를 가리키게 된다.
            results.add(new ArrayList<>(path));
            return;
        }
        
        for(int num : nums) {
            // 현재 방문한 경로에 없다면
            if(!path.contains(num)) {
                // 현재까지 방문한 경로에 추가
                path.add(num);

                // dfs 탐색 시작
                dfs(path, results, nums);

                // 현재 방문한 경로에서 제거, 인덱스가 아닌 값을 기준으로 제거하기 위해 Integer 클래스로 전달
                path.remove(Integer.valueOf(num));
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // 결과를 담을 변수
        List<List<Integer>> results = new ArrayList<>();
        
        // 현재까지 방문한 경로 저장
        List<Integer> path = new ArrayList<>(); 
        dfs(path, results, nums);
        
        return results;
    }
}
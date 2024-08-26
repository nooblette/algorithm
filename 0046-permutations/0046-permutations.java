class Solution {
        public void dfs(
        List<List<Integer>> results, 
        List<Integer> prevElements, 
        List<Integer> elements
    ) {
        // 리프노드에 도달하면 결과에 추가
        if(elements.isEmpty()) {
            results.add(prevElements.stream().collect(Collectors.toList()));
        }

        // 전달받은 elements 탐색
        for(Integer e : elements) {
            // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements를 새롭게 구성
            // elements를 바로 nextElements에 할당하면 동일한 참조값을 가리키게되어 별도로 리스트를 선언한다.
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            // prevElements 기존 값에 현재 엘리먼트 추가(방문한 경로를 저장하는 역할)
            prevElements.add(e);

            // dfs g호출
            dfs(results, prevElements, nextElements);

            // 돌아온 이후 prevElements 현재 엘리먼트 삭제
            prevElements.remove(e);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // 결과 저장 리스트 선언
        List<List<Integer>> results = new ArrayList<>();
        
        // int[]를 List<Integer>로 변경
        List<Integer> lst = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        
        // dfs 시작
        dfs(results, new ArrayList<>(), lst);
        
        return results;
    }
}
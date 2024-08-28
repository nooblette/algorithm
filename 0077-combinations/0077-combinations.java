class Solution {
    public void dfs(
        List<List<Integer>> results,
        List<Integer> elements,
        int n,
        int k,
        int start // start는 이전 레벨의 탐색보다 항상 1만큼 큰 값을 갖는다.
    ) {
        // k개의 조합을 모두 탐색한 경우
        if(k == 0) {
            results.add(new ArrayList<>(elements));
            return;
        }

        // 현재 엘리먼트 이후 인덱스부터 이후 엘리먼트 탐색
        for(int i = start; i <= n; i++) {
            // 전달받은 엘리먼트에 현재 엘리먼트 추가
            elements.add(i);

            // 재귀 dfs
            dfs(results, elements, n, k - 1, i + 1);

            // 돌아온 이후 현재 엘리먼트 제거
            elements.removeLast();
        }
    }
        
    public List<List<Integer>> combine(int n, int k) {
        // 결과 저장 리스트 선언
        List<List<Integer>> results = new ArrayList();
        
        // dfs 탐색 시작
        dfs(results, new LinkedList<>(), n, k, 1);
        
        return results;
    }
}
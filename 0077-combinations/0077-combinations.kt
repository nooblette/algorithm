class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        // 결과 저장 리스트 선언
        val results: MutableList<List<Int>> = mutableListOf()
        
        // 중첩함수로 선언
        fun dfs(elements: LinkedList<Int>, start: Int, k: Int) {
            // k개의 조합을 모두 찾은 경우
            if(k == 0) {
                results.add(elements.toList())
            }
            
	        // 현재 엘리먼트 이후 인덱스부터 이후 엘리먼트 탐색
            for(i in start..n) {
                elements.add(i)
                dfs(elements, i + 1, k - 1)
                elements.removeLast()
            }
        }
        
        // dfs 시작
        dfs(LinkedList(), 1, k)
        return results
    }
}
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        // 결과 저장 리스트, MutableList<List<Int>> 타입으로 선언
        val results: MutableList<List<Int>> = mutableListOf()
        
        fun dfs(prevElements: MutableList<Int>, elements: List<Int>) {
            // 리프 노드에 도달하면 결과에 추가
            if (elements.isEmpty()) {
                results.add(ArrayList(prevElements))  // prevElements의 복사본을 추가
                return
            }
            
            // 전달받은 엘리먼트 탐색
            for (e in elements) {
                // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements를 새롭게 구성
                val nextElements: MutableList<Int> = ArrayList(elements)
                nextElements.remove(e)
                
                // prevElements 기존 값에 현재 엘리먼트 추가(방문한 경로를 저장하는 역할)
                prevElements.add(e)

                // dfs 호출
                dfs(prevElements, nextElements)

                // 돌아온 이후 prevElements에서 현재 엘리먼트 삭제
                prevElements.remove(e)
            }
        }
        
        // int[]를 List<Integer>로 변경, 자바 8 호환 가능
        val lst = nums.toList()
        
        // dfs 시작
        dfs(mutableListOf(), lst)
        return results
    }
}
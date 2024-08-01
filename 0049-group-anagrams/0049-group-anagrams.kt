class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // 애너그램 결과를 보관하기 위한 맵 선언
        val results: MutableMap<String, MutableList<String>> = mutableMapOf()
        
        // 입력값인 문자열 배열 순회
        for(str in strs) {
            // 문자열 정렬
            val key = str.toCharArray().sorted().joinToString("")
            
            // 만약 기존에 없던 키라면 빈 리스트 삽입
            results.getOrPut(key) { mutableListOf() }
            
            // 키에 해당하는 리스트에 문자열 값 추가
            results[key]!!.add(str);
        }
        
        // 문제에서 요구하는 반환형으로 변경
        return ArrayList<List<String>>(results.values)
    }
}
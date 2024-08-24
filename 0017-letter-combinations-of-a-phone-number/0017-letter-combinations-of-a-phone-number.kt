class Solution {
    fun letterCombinations(digits: String): List<String> {
        // 결과를 저장할 리스트 선언
        val result: MutableList<String> = mutableListOf()

        // 예외 처리
        if(digits.isEmpty()) {
            return result
        }

        // 번호로 조합 가능한 문자 목록 구성
        val dic: Map<Char, List<Char>> = mapOf(
            '0' to listOf(),
            '1' to listOf(),
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z')
        )


        fun dfs(index: Int, path: StringBuilder) {
            // 끝까지 탐색했으면 결과를 저장하고 리턴
            if(path.length == digits.length) {
                result.add(path.toString())
                return
            }
            
            // 현재 자리 숫자에 대항하는 모든 문자열 탐색
            for(c in dic[digits[index]]!!) {
                // 현재자리 +1, 지금까지 구성된 문자열 path 이용하여 재귀 DFS
                dfs(index +1, StringBuilder(path).append(c))
            }
	    }
	
    // 현재자리 0, 빈 문자열 이용 DFS 시작
	dfs(0, StringBuilder())
	return result
    }
}
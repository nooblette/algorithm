class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val used: MutableMap<Char, Int> = mutableMapOf()
        
        var maxLength = 0
        var left = 0
        var right = 0
        
        // 문자열을 문자 단위로 반복
        for(c in s.toCharArray()){
            if(left <= used.getOrDefault(c, -1)) {
                // 이미 등장한 문자이며 슬라이딩 윈도우 범위에 포함되는 경우
                left = used[c]!! + 1
            } else {
                // 새로 등장한 문자인 경우
                maxLength = max(maxLength, right - left + 1)
            }
            
            // 현재 문자의 위치 추가
            used[c] = right
            right++
        }
        
        return maxLength
    }
}
class Solution {
    fun longestPalindrome(s: String): String {
        var start: Int = 0 // 가장 긴 팰린드롬이 시작하는 인덱스
        var maxLen: Int = 0 // 가장 긴 팰린드롬의 길이
        
        // 길이가 1인 경우 예외 처리
        if(s.length < 2) return s
        
        for(i in 0 until s.length - 1) {
            // 길이가 홀수인 팰린드롬의 길이
            val oddLen: Int = expandAroundCenter(s, i, i)

            // 길이가 짝수인 팰린드롬의 길이
            val evenLen: Int = expandAroundCenter(s, i, i+1)

            val len: Int = maxOf(oddLen, evenLen)

            // 새로운 팰린드롬의 길이와 시작 인덱스 계산
            if(len > maxLen) {
                maxLen = len

                // (maxLen-1) / 2 : 전체 팰린드롬 길이에서 중앙에 있는 문자를 제외(= maxLen-1)하고 한쪽에 있는 문자의 개수(= /2)를 계산
                start = i - (maxLen-1) / 2
            }
        }
        
        return s.substring(start, start + maxLen)
    }
    
    fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        // 코틀린의 메서드 파라미터는 수정할 수 없으므로 var 별도 선언
        var l = left
        var r = right
        
        while(l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        
        // 팰린드롬의 길이(한 칸씩 이동하기 전의 left와 right에 대한 길이를 계산) 반환
        return r - l - 1
    }
}
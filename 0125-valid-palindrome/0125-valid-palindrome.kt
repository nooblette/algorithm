class Solution {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length -1
        
        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while(start < end) {
            when {
                // 영숫자인지 판별, 유효하지 않다면 한 칸 이동
                !Character.isLetterOrDigit(s[start]) -> {
                    start++
                }
                // 영숫자인지 판별, 유효하지 않다면 한 칸 이동
                !Character.isLetterOrDigit(s[end]) -> {
                    end--
                }
                else -> {
                    // 이 외에는 유효한문자열, 소문자로 변경하여 두문자가 같은지 검증한다.
                    if(Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                        return false
                    }
                    
                    start++
                    end--
                }
            }
        }
        
        return true
    }
}
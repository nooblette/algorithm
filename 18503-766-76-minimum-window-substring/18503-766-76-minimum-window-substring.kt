class Solution {
    fun minWindow(s: String, t: String): String {
        // 조건을 만족하기 위해 필요한 문자와 문자별 카운트를 정의
        val need: MutableMap<Char, Int> = mutableMapOf()
        
        // 찾아야하는 문자열의 모든 문자를 삽입한다.
        for(c in t.toCharArray()) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        // 필요한 문자 전체 카운터 지정
        var missing = t.length
        
        var left = 0
        var right = 0
        var start = left
        var end = right
        var minLen = Int.MAX_VALUE
        
        for(c in s.toCharArray()) {
            // 오른쪽 포인터 이동
            right++
            
            if(need.containsKey(c)) {
                // need의 value가 0보다 큰 값이면 필요했던 값이므로 전체 카운트를 감소
                if(need[c]!! > 0) {
                    missing--
                }

                // 필요한 문자를 찾았으므로 찾아야하는 문자의 카운트도 감소한다.
                need[c] = need[c]!! - 1
            }
            
            // 필요한 문자를 모두 찾은 경우
            if(missing == 0) {
                // 정답을 찾는데 필요한 문자가 아니거나 필요한 문자지만 이후에 등장하는 동안 left를 우측으로 이동
                while(left < right && (!need.containsKey(s[left]) || need.containsKey(s[left]) && need[s[left]]!! < 0)) {
                    // 이미 등장한 문자라면 사용 횟수를 1 증가한다.
                    if(need.containsKey(s[left]) && need[s[left]]!! < 0) {
                        need[s[left]] = need[s[left]]!! + 1
                    }
                    left++
                }
                
                // 찾은 길이가 기존 최소 길이보다 더 작으면 교체
                if(minLen > right - left + 1) {
                    minLen = right - left + 1
                    start = left
                    end = right
                }

                // 마지막에 빠지는 값은 right를 증가하면서 다시 존재하는지 찾아야한다.
                if(need.containsKey(s[left])) {
                    need[s[left]] = need[s[left]]!! + 1
                    missing++
                    left++
                }
            }
        }
        
        return s.substring(start, end)
    }
}
class Solution {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size - 1
        
        // 서로 중앙으로 이동하면서 겹치는 지점에 도달하면 종료
        while(start < end){
            // also 키워드로 우아하게 스왑
            s[start] = s[end].also{s[end] = s[start]}
            
            // 인덱스 한칸씩 이동
            start++
            end--
        }
    }
}
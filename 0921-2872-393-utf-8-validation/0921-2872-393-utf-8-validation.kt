class Solution {
    fun validUtf8(data: IntArray): Boolean {
        // 문자의 시작 바이트 인덱스
        var start = 0
        
        // 자릿수 검증
        fun check(size: Int): Boolean {
            // size만큼 이동하면서 각 바이트가 10으로 시작하는지 검증
            for(i in start + 1 until start + size + 1) {
                if(i >= data.size || data[i] shr 6 != 0b10) {
                    return false
                }
            }
            
            return true
        }
        
        // 문자 전체 길이만큼 순회
        while(start < data.size) {
            // 문자의 시작 바이트
            val first = data[start]
            when {
                // 11110으로 시작하는 경우 나머지가 3바이트이고 10으로 시작해야한다.
                first shr 3 == 0b11110 && check(3) -> start += 4
                // 1110으로 시작하는 경우 나머지가 2바이트이고 10으로 시작해야한다.
                first shr 4 == 0b1110 && check(2) -> start += 3
                // 110으로 시작하는 경우 나머지가 1바이트이고 10으로 시작해야한다.
                first shr 5 == 0b110 && check(1) -> start += 2
                // 1바이트 문자인 경우
                first shr 7 == 0 -> start++
                else -> return false
            }
        }
        
        return true
    }
}
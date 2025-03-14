class Solution {
    fun hammingWeight(n: Int): Int {
        // 코틀린은 함수 파라미터를 조작할 수 없으므로 별도 변수로 할당한다
        var n = n
        var count = 0
        
        // 0이 될때까지 반복
        while(n > 0) {
            // 1을 뺀 값과 AND 연산
            n = n and n-1
            
            // 1비트씩 빠지게 되므로 카운트는 1씩 증가
            count++
        }
        
        return count
    }
}
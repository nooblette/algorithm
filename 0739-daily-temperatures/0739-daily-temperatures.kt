class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // 결과를 담을 정수형 배열
        val result = IntArray(temperatures.size)
        
        // 결과 처리룰 위한 스택 선언
        val stack: Deque<Int> = LinkedList()
        
        for(i in temperatures.indices) {
            // 현재 온도가 스택에 쌓아둔 인덱스의 온도보다 더 크다면
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val last = stack.pop()
                
                // 두 인덱스의 차이를 정답으로 반환할 배열(result)에 추가
                result[last] = i - last
            }

            // 현재 인덱스를 다시 스택에 저장
            stack.push(i)
        }
        
        return result
    }
}
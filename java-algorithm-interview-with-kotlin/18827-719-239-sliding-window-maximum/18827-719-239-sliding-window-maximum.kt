class Solution {    
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        fun startIndex(i: Int): Int = i - k + 1
        
        val result: MutableList<Int> = mutableListOf()
        
        // 인덱스를 저장하는 데크 선언
        val dq: Deque<Int> = LinkedList()
        
        // 배열 전체 순회
        for(i in nums.indices) {
            // 데크 맨 앞이 윈도우 바깥에 있다면 삭제
            if(!dq.isEmpty() && dq.peek() < startIndex(i)) {
                dq.poll()
            }
            
            // 현재 값보다 작다면 데크에서 모두 삭제, 데크는 현재 값보다 큰 인덱스만 남게 된다.
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast()
            }
            
            // 데크에 현재 인덱스 추가
            dq.add(i)
            
            // 데크의 원소가 윈도우의 크기를 만족했을 때 데크의 첫번째 값이 윈도우의 최대값이 된다.
            if(startIndex(i) >= 0 ) {
                result.add(nums[dq.peek()])
            }
        }
        
        // List<Integer>를 IntArray로 변환하여 리턴
        return result.toIntArray()
    }
}
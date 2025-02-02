class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        // 인덱스를 저장하는 데크 선언
        Deque<Integer> dq = new ArrayDeque<>();

        // 배열 전체 순회
        for(int i = 0; i < nums.length; i++) {
            // 데크 맨 앞이 윈도우 바깥에 있다면 제거
            if(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // 현재 값보다 작다면 데크에서 모두 삭제, 데크는 현재 값보다 큰 인덱스만 남게 된다.
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.add(i);

            // 데크의 첫번째 값은 가장 큰 값이므로 정답에 추가
            if(i >= k - 1) {
                result.add(nums[dq.peek()]);
            }
        }
        
        // List<Integer>를 int[]로 변환하여 리턴
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
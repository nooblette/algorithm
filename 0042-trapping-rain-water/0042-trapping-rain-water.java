class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;
        
        for(int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                
                if(stack.isEmpty()) {
                    break;
                }
                
                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;
                
                // 현재 높이 또는 스택의 마지막 위치 높이중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];
                
                // 물에 쌓이는 일은 거리와 물 높이의 곱
                volume += distance * waters;
            }
            
            stack.push(i);
        }
        
        return volume;
    }
}
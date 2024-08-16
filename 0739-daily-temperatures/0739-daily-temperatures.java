class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 결과를 담을 정수형 배열
        int[] result = new int[temperatures.length];
        
        // 결과 처리를 위한 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < temperatures.length; i++) {
            // 현재 온도가 스택에 쌓아둔 인덱스의 온도보다 더 크다면
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                //  두 인덱스의 차이를 정답으로 반환할 배열(result)에 추가
                result[last] = i - last;
                System.out.println(last + ": " + result[last]);
            }

            // 현재 인덱스를 다시 스택에 저장
            stack.push(i);
        }
        
        return result;
    }
}
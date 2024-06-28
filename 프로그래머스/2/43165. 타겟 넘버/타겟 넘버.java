import java.util.*;

class Solution {
    static class CustomInt {
        private int answer;
        
        public CustomInt() {
            this.answer = 0;
        }
        
        public void increment() {
            answer += 1;
        }
        
        public int get() {
            return answer;
        }
    }
    public int solution(int[] numbers, int target) {
        CustomInt answer = new CustomInt();
        boolean[] visited = new boolean[numbers.length];
        Arrays.fill(visited, false);
        
        dfs(new ArrayDeque<>(), numbers, 0, answer, target);
        return answer.get();
    }
    
    private void dfs(Deque<Integer> path, 
                     int[] numbers, 
                     int depth,
                     CustomInt answer, 
                     int target) {
        if(depth == numbers.length) {
            int sum = 0;
            for(Integer number : path) {
                sum += number;
            }
            
            if(sum == target) {
                answer.increment();
            }
            
            return;
        }
        
        int number = numbers[depth];
        path.add(number);
        dfs(path, numbers, depth + 1, answer, target);
        path.removeLast();
            
        path.add(number * -1);
        dfs(path, numbers, depth + 1, answer, target);
        path.removeLast();
    }
}
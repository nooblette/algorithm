import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K) {
                break;
            }
            
            if(pq.isEmpty()) {
                answer = -1;
                break;
            }
            
            int second = pq.poll();
            pq.offer(first + (second * 2));
            answer += 1;
        }
        return answer;
    }
}
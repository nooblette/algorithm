import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // scoville 원소를 우선순위 큐에 삽입
        for(int s : scoville) {
            // 삽입하면서 스코빌을 기준으로 오름차순 정렬된다.
            pq.add(s);
        }
        
        // 두 음식을 꺼낼 수 있는 동안 반복
        int answer = 0;
        
        // 섞을 필요가 없는 경우
        if(pq.peek() >= K) {
            return answer;
        }
        
        while(pq.size() >= 2) {
            // 두 음식을 섞어서 새로운 스코빌 지수를 갖는 음식을 만든다. 그 후 다시 우선순위 큐에 넣는다.
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
            
            // 모든 음식의 스코빌 지수가 K 이상이 되면 반복 횟수를 반환한다.
            if(pq.peek() >= K) {
                return answer;
            }
        }
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에 -1을 return한다.
        return -1;
    }
}
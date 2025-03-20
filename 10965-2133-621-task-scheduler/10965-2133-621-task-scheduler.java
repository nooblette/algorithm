class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 작업별 크기 저장 - 원시형 사용
        int[] freqsIntArray = new int[26];
        for(char task : tasks) {
            freqsIntArray[task - 'A']++;
        }
        
        // 문자 빈도 큰 순서로 내림차순하는 우선순위 큐 선언
        // 현재 구간(intervals)을 기준으로 탐색하므로 등장 횟수만 있으면 된다.
        // 우선순위 큐의 각 원소는 문자별 등장 횟수가 된다. 따라서 탐색 중인 간격내에서는 동일한 문자가 다시 등장하지 않는다.
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freqsIntArray) {
            if(f > 0) pq.add(f);
        }

        int result = 0;
        while(true) {
            // 현재 탐색 구간
            int intervals = 0;
            
            // 간격 n 내에 처리한 작업 중 아직 횟수가 남은 작업을 저장
            List<Integer> list = new ArrayList<>();
            while(!pq.isEmpty()) {
                int frequency = pq.poll();

                // 아직 간격 n 내에 있는 경우
                if(intervals < n + 1) {
                    intervals++;
                    result++;

                    // 처리 횟수가 남은 작업 저장
                    if(frequency > 1) 
                        list.add(frequency - 1);
                } else {
                    // 간격 n이 끝난 경우 남은 작업은 모두 list에 넣는다.
                    list.add(frequency);
                }
            }
            
            // 더 이상 남은 작업이 없는 경우
            if(list.isEmpty())
                break;
            
            // 남은 작업은 우선순위 큐에 삽입
            pq.addAll(list);
            
            // 현재 간격이 주어진 최대 간격 n보다 작지만 우선순위 큐에 원소가 없는 경우 최대 간격을 채우기 위한 나머지 구간(최대 간격 - 현재 구간)만큼 idle 상태에 들어간다.
            result += ((n + 1) - intervals);
        }
        
        return result;
    }
}
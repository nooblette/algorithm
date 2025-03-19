class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 첫번째 값(키)을 기준으로 내림차순 정렬, 같다면 두번째 값(k)를 기준으로 오름차순 정렬하는 우선순위 큐 선언
        // Compartor의 구현부가 음수를 반환하면 a, b 순서로 정렬, 양수를 반환하면 b, a 순서로 정렬된다.
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
        );
        
        // 우선순위 큐에 배열 입력 값 삽입
        for(int[] person : people) {
            pq.add(person);
        }
        
        // 우선순위 큐에서 모두 추출할때 까지 반복
        List<int[]> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            // 큰 키 우선
            int[] person = pq.poll();
            
            // k번 인덱스에 추가, result에는 항상 자기보다 키가 크거나 같은 사람만 있으므로 k번째 인덱스에 그대로 추가하면 된다.
            result.add(person[1], person);
        }
        
        // int[] -> List 변환
        return result.toArray(new int[people.length][2]);
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        List<int[]> answer = new ArrayList<>();
        
        // 주어진 배열을 시작점을 기준으로 오름차순 정렬한다.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 새로운 구간 탐색
        int[] newInterval = intervals[0];
        for(int i = 1; i < n; i++) {
            // 겹치는 구간이 없는 경우
            if(intervals[i][0] > newInterval[1]) {
                answer.add(newInterval);
                newInterval = intervals[i];
            } else {
                // 겹치는 구간이 있는 경우
                // 새로운 구간의 종료 구간을 늘린다.
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        
        // 마지막 구간 추가
        answer.add(newInterval);
        
        // 리스트를 2차원 배열로 변환하여 반환
        return answer.toArray(new int[answer.size()][2]);
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 결과 리스트 선언
        List<int[]> result = new ArrayList<>();
        
        // intervals 탐색 - 주어진 리스트를 한 번만 순회한다. (O(n))
        for(int[] interval : intervals) {
            // 새로운 구간보다 이전에 오는 구간인 경우
            if(interval[1] < newInterval[0]) {
                result.add(interval);
            } else if(newInterval[1] < interval[0]) {
                // 새로운 구간보다 이후에 오는 구간인 경우
                result.add(newInterval);
                
                // if 조건문에서 newInterval을 사용하고 있으므로 조건에 걸리지 않도록 갱신해준다.
                newInterval = interval;
            } else {
                // 구간 병합
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        // 탐색 후 마지막 구간 추가
        result.add(newInterval);
        
        // 리스트를 배열로 변환하여 반환
        return result.toArray(new int[result.size()][2]);
    }
}
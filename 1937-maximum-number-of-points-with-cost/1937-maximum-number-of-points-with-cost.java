class Solution {
    public long maxPoints(int[][] points) {
        // row를 순회하며 특정 컬럼을 선택할때 최대값을 저장한다.
        // dp[i] = i번째 컬럼을 선택했을때 구하는 최대값
        long[] dp = new long[points[0].length];
        
        // dp 배열초기화
        for(int i = 0; i < points[0].length; i++) {
            dp[i] = points[0][i];
        }
        
        // dp 탐색 진행
        for(int i = 1; i < points.length; i++) {
            // 중간 배열 선언
                
            // left : 왼쪽에서 오른쪽으로 이동하면서 직전 row에서 구한 최대 값을 저장한다.
            // 즉 직전 row에서 구한 값에 대해 이전 컬럼의 최대값을 사용할지, 동일한 컬럼의 값을 사용할지 결정한다.
            long[] left = new long[points[0].length];
            left[0] = dp[0];
            for(int j = 1; j < points[0].length; j++) {
                left[j] = Math.max(left[j - 1] - 1, dp[j]);
            }
            
            // right : 오른쪽에서 왼쪽으로 이동하면서 직전 row에서 구한 최대 값을 저장한다.
            // 최대값이 직전 row의 현재 column보다 이전 위치(대각선 왼쪽 방향)에서 올 수도 있다.
            // 혹은 최대값이 현재 column보다 이후 위치(대각선 오른쪽 방향)에서 올 수도 있다.
            long[] right = new long[points[0].length];
            right[points[0].length - 1] = dp[points[0].length - 1];
            for(int j = points[0].length - 2; j > -1; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[j]);
            }
            
            // 이전 row까지의 최대 값과 points 값을 합하여 임시 변수에 저장한다.
            long[] temp = new long[points[0].length];
            for(int j = 0; j < points[0].length; j++) {
                temp[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            
            // dp 갱신
            dp = temp;
        }
        
        
        // dp 배열의 각 인덱스는 해당 컬럼을 선택했을때 합을 갖고 있다.
        // 따라서 이 중 최대 값을 반환한다. 
        long answer = 0;
        for(int i = 0; i < points[0].length; i++) {
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}
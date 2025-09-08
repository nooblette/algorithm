class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 탐색 범위
        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        // 탐색 범위가 유효한 동안 나선형으로 탐색
        List<Integer> result = new ArrayList<>();
        while(left <= right && top <= bottom) {
            // 1. 오른쪽으로 이동
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // 탐색 후 첫 행을 탐색 경계에서 제외한다.
            top++;

            // 2. 아래로 이동
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            // 탐색 후 오른쪽 열은 탐색 경계에서 제외한다.
            right--;

            // 3. 왼쪽으로 이동 - 행이 남아있을 때만 
            if (top <= bottom) { 
                for (int i = right; i >= left; i--) { 
                    result.add(matrix[bottom][i]); 
                } 

                // 탐색 후 마지막 행은 탐색 경계에서 제외한다.
                bottom--; 
            } 

            // 4. 위로 이동 - 열이 남아있을 때만 
            if (left <= right) { 
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                } 

                // 탐색 후 왼쪽 열은 탐색 경계에서 제외한다.
                left++;
            }
        }

        return result;
    }
}

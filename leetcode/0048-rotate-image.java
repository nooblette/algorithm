class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 대각선을 기준으로 행과 열 변경
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 행 뒤집기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}

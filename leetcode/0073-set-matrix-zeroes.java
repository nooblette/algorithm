class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1. 첫번째 행과 열에 0이 있었는지 확인
        boolean isFirstRowZero = false;
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        
        boolean isFirstColZero = false;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // 2. 두번째 행과 열부터 탐색 0인 부분이 있다면 첫번째 행과 열을 변경 (1번 케이스와 탐색 범위가 서로 다름)
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 1번 케이스에서 기록했던 최초 0 처리
        if(isFirstRowZero) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isFirstColZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

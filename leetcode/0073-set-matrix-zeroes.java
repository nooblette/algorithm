class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 첫번째 행에 0이 있었는지 최초 정보 기록
        boolean hasFirstRowZero = false;
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                hasFirstRowZero = true;
            }
        }

        // 첫번째 열에 0이 있었는지 최초 정보 기록
        boolean hasFirstColZero = false;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                hasFirstColZero = true;
            }
        }

        // matrix 배열을 탐색
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 0이라면
                if(matrix[i][j] == 0) {
                    // 첫번째 행, 열 값을 0으로 변경하여 대상 행, 열임을 마킹
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 첫번째 행에서 0인 열이 있다면, 동일한 열을 모두 0으로 변경
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < m; j++) { 
                    matrix[j][i] = 0;
                }
            }
        }

        // 첫번째 열에서 0인 행이 있다면, 동일한 행을 모두 0으로 변경
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < n; j++) { 
                    matrix[i][j] = 0;
                }
            }
        }

        // 최초 정보를 기반으로 첫번째 행에 0이 있었다면 첫번째 행을 0으로 변경
        if(hasFirstRowZero) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        // 최초 정보를 기반으로 첫번째 열에 0이 있었다면 첫번째 열을 0으로 변경
        if(hasFirstColZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

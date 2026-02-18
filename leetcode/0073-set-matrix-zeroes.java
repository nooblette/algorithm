class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 최초 값이 0인 위치 저장
        // 2차원 배열이 아니라 1차원 배열 두 개를 선언하여 공간 복잡도를 O(m + n)으로 개선
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // 기존 배열을 0으로 변경
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 해당 행이나 열에 0인 값이 있다면 그 행, 열은 모두 0으로 만든다.
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

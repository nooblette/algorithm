class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        
        // 첫 행의 맨 뒤로 지정
        int col = matrix[0].length - 1;
        
        // 포인터가 행렬 내에 있다면 계속 탐색
        while(row < matrix.length && col >= 0) {
            final int element = matrix[row][col];
            // 정답을 찾은 경우 true 반환
            if(element == target) {
                return true;
            }
            
            // 원소가 target보다 작다면 아래쪽 이동한다.
            if(element < target) {
                row++;
            } else {
                // 원소가 target보다 크다면 왼쪽으로 이동한다.
                col--;
            }
        }
        
        // 정답을 찾지 못한 경우 false 반환
        return false;
    }
}
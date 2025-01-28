class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        
        // 첫 행의 맨 뒤로 지정
        var col = matrix[0].size - 1
        
        // 포인터가 행렬 내에 있다면 계속 탐색
        while(row < matrix.size && col >= 0) {
            val element = matrix[row][col]
            
            when {
                // 정답을 찾은 경우 true 반환
                element == target -> return true
                // 원소가 target보다 크다면 왼쪽으로 이동
                element > target -> col--
                // 원소가 target보다 작다면 아래쪽으로 이동
                else -> row++
            }
        }
        
        return false
    }
}
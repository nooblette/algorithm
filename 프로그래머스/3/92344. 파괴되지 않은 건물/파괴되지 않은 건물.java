class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length; // 행의 개수
        int M = board[0].length; // 열의 개수
        
        // 누적합 계산을 위한 2차원 배열
        int[][] matrix = new int[N + 1][M + 1];
        
        // skill 값에 따른 누적합 계산
        for (int[] s : skill) {
            // 힐 or 공격 여부
            int degree = s[0] == 1 ? s[5] * (-1) : s[5];

            matrix[s[1]][s[2]] += degree; // 시작점
            matrix[s[1]][s[4] + 1] -= degree; // 오른쪽 끝 + 1
            matrix[s[3] + 1][s[2]] -= degree; // 아래쪽 끝 + 1
            matrix[s[3] + 1][s[4] + 1] += degree; // 오른쪽과 아래쪽 끝 경계에서 영향 제거
        }
        
        // 누적합 계산
        // 좌우
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < M; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        // 상하
        for(int j = 0; j < M; j++) {
            for(int i = 1; i < N; i++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        // 파괴되지 않은(0을 초과하는) 건물 개수 계산
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] + matrix[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
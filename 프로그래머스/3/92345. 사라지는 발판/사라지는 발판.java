class Solution {
    // 동서남북
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    int[][] board;
    int N;
    int M;
    
    private int dfs(int playerRow, int playerCol, int opponentRow, int opponenetCol) {
        // 이동할 수 없는 발판에 도달한 경우 0 반환
        if(board[playerRow][playerCol] == 0) {
            return 0;
        }
        
        int result = 0;
        for(int[] direction : directions) {
            int playerNewRow = playerRow + direction[0];
            int playerNewCol = playerCol + direction[1];
            
            if(playerNewRow < 0 || playerNewRow >= N || playerNewCol < 0 || playerNewCol >= M || board[playerNewRow][playerNewCol] == 0) {
                continue;
            }
            
            // 현재 발판 제거
            board[playerRow][playerCol] = 0;
            
            // 상대에게 턴을 넘기고(dfs() 호출) 내가 둔 수를 합산(+1)한다.
            int moveCount = dfs(opponentRow, opponenetCol, playerNewRow, playerNewCol) + 1;
            
            // 현재 발판 복구
            board[playerRow][playerCol] = 1;
            
            // 앞선 탐색에서는 지는 판이였는데 이번 판을 이기는 경우
            if(result % 2 == 0 && moveCount % 2 == 1) {
                // 이번 이동 횟수를 취한다.
                result = moveCount;
            } else if(result % 2 == 0 && moveCount % 2 == 0) {
                // 앞선 탐색에서 지는 판이였고 이번 판도 지는 경우
                // 가능한 오래 버틴다
                result = Math.max(result, moveCount);
            } else if(result % 2 == 1 && moveCount % 2 == 1) {
                // 앞선 탐색에서 이기는 판이였고 이번 판도 이기는 경우
                // 가능한 적은 이동 횟수를 취한다.
                result = Math.min(result, moveCount);
            }
        }
        
        return result;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        // N x M 배열
        this.N = board.length;
        this.M = board[0].length;
        this.board = board;
        
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}
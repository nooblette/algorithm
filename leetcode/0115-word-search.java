class Solution {
    private int[][] heads = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        // 경로 찾기는 DFS + 백트래킹
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                // 모든 위치가 시작점이 될 수 있음
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }     

        return false;   
    }

    private boolean dfs(char[][] board, String word, int curY, int curX, int pos) {
        // 모든 글자를 찾은 경우
        if(pos == word.length()) {
            return true;
        }

        // 탐색 범위를 벗어난 경우
        if(curY < 0 || curY >= board.length || curX < 0 || curX >= board[0].length) {
            return false;
        }

        // 원하는 문자가 아닌 경우
        if(board[curY][curX] != word.charAt(pos)) {
            return false;
        }

        // 원하는 문자를 찾은 경우
        char temp = board[curY][curX];

        // 현재 위치 방문 처리
        board[curY][curX] = '0';
        for(int[] head : heads) {
            if(dfs(board, word, curY + head[0], curX + head[1], pos + 1)) {
                return true;
            }
        }

        // 백트래킹: 원래 문자로 복구
        board[curY][curX] = temp;

        return false;
    }
}

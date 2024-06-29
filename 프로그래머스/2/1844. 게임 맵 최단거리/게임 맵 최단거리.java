import java.util.*;

class Solution {
    static class Bfs {
        int level;
        int y;
        int x;
        
        public Bfs(int level, int y, int x) {
            this.level = level;
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        Queue<Bfs> q = new LinkedList<>();
        q.offer(new Bfs(0, 0, 0));
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        // 모든 요소를 false로 초기화
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(visited[i], false);
        }
        visited[0][0] = true;

        // bfs 탐색
        int answer = 0;
        while(true) {
            if(q.isEmpty()) {
                return -1;
            }
            
            Bfs bfs = q.poll();
            
            int y = bfs.y;
            int x = bfs.x;
            
            if(y + 1 == maps.length && x + 1 == maps[0].length) {
                return bfs.level + 1;
            }
            
            int level = bfs.level + 1;
            if(x+1 < maps[y].length && maps[y][x+1] == 1 && !visited[y][x+1]){
                // 오른쪽 면이 존재하고 이동할 수 있고 방문한적이 없는 경우
                visited[y][x+1] = true;
                q.offer(new Bfs(level, y, x+1));
            }
                
            if(x-1 >= 0 && maps[y][x-1] == 1 && !visited[y][x-1]) {
                // 왼쪽 면이 존재하고 이동할 수 있고 방문한적이 없는 경우 경우
                visited[y][x-1] = true;
                q.offer(new Bfs(level, y, x-1));
            }
                
            if(y+1 < maps.length && maps[y+1][x] == 1 && !visited[y+1][x]) {
                // 아래쪽 면이 존재하고 이동할 수 있고 방문한적이 없는 경우
                visited[y+1][x] = true;
                q.offer(new Bfs(level, y+1, x));
            }
                
            if(y-1 >= 0 && maps[y-1][x] == 1 && !visited[y-1][x]) {
                // 위쪽 면이 존재하고 이동할 수 있고 방문한적이 없는 경우
                visited[y-1][x] = true;
                q.offer(new Bfs(level, y-1, x));
            }
            
            answer += 1;
        }
    }
}
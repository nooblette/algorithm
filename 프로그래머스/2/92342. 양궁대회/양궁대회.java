import java.util.*;

class Solution {
    // 라이언이 획득한 점수
    int maxScore = 0;
    
    // 라이언이 승리할때 점수별 맞힌 목록
    int[] answer = new int[11];
    
    // 어피치가 획득한 점수 목록, 파라미터 목록에서 전달하지 않기 위해 클래스 멤버 변수로 선언
    int[] info;
    
    // 라이언과 어피치가 점수별로 맞힌 점수를 비교하여 라이언이 획득한 점수를 구한다.
    public int calScore(int[] lion) {
        int diff = 0;
        for(int i = 0; i <= 10; i++) {
            // a = b = 0인 경우 두 선수 모두 점수를 획득하지 못한다.
            if(lion[i] == 0 && info[i] == 0) {
                continue;
            }

            // 둘 중 더 많은 화살을 맞힌 사람이 점수를 획득한다. 같다면 어피치가 점수를 획득한다.
            diff = (lion[i] > info[i]) ? diff + (10 - i) : diff - (10 - i);
        }

        return diff;
    }
    
    public void dfs(int index, int[] lion, int arrow) {
        // index : 각 점수이면서 DFS의 탐색 깊이
        if(index == 11) {
            // 최종 인덱스에 도달했을 때, 아직 화살이 남아있다면 모두 0점에 부여하고 점수 차이를 계산한다.
            lion[10] = arrow;
            
            // 라이언의 점수 계산
	        int score = calScore(lion);
            
            // 기존에 구한 최고 점수 차이를 능가하면 갱신
            if(score > maxScore) {
                maxScore = score;
                answer = Arrays.copyOf(lion, lion.length);
            } else if(score == maxScore) {
                // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러가지일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 반환
                for(int i = 10; i >= 0; i--) {
                    if(lion[i] == answer[i]) {
                        continue;
                    }

                    // 낮은 점수를 더 많이 맞췄다면 갱신
                    if(lion[i] > answer[i]) {
                        answer = Arrays.copyOf(lion, lion.length);
                    }
                    
                    // 새로운 배열이든, 기존 배열이든 낮은 점수를 더 많이 맞춘 조합이 있다면 탐색 종료
                    break;
                }
            }

            return;
        }
        
        // 어피치가 획득한 점수보다 더 많이 쏠 수 있다면
        if(info[index] < arrow) {
            // 어피치보다 한 발 더 쏜다.
            lion[index] = info[index] + 1;
            dfs(index + 1, lion, arrow - lion[index]);
            lion[index] = 0;
        }

        dfs(index + 1, lion, arrow);
    }
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, new int[11], n);
        
        // 라이언이 점수를 획득하는 경우가 없는 경우
        if(maxScore == 0) {
            return new int[]{-1};
        }
        
        return answer;
    }
}
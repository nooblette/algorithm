import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 앞번호 학생에겍 빌려주는 것이 최적해이므로 배열을 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여분 체육복이 있으나 도난 당한 경우 빌려줄 수 없다.
        // isLostList : 체육복을 분실했는지 여부를 저장
        boolean[] isLostList = new boolean[n];
        Arrays.fill(isLostList, false);
        for(int l : lost) {
            isLostList[l-1] = true;
        }
        
        // isReserveList : 체육복을 빌려줄 수 있는 학생 번호를 저장
        boolean[] isReserveList = new boolean[n]; 
        Arrays.fill(isReserveList, false);
        for(int r : reserve){
            boolean isReserve = true;
            for(int l : lost) {
                if(r == l) {
                    // 여분 체육복이 있으나 도난 당한 경우
                    isReserve = false;
                    break;
                }
            }
            
            isReserveList[r-1] = isReserve;
            if(!isReserve) {
                isLostList[r-1] = false;
            }
        }
        
        // 체육복을 잃어버린 학생 수 초기화
        int answer = n;
        for(int i = 0; i < n; i++) {
            if(isLostList[i]) {
                answer -= 1;
            }
        }
        
        // 체육 수업 참여 가능 최대 학생수 계산
        for(int i = 0; i < n; i++){
            // 1. 체육복을 빌려줄 수 없는 경우
            if(!isReserveList[i]) {
                continue;
            }
            
            if(i-1 >= 0 && isLostList[i-1] && i+1 < n && isLostList[i+1]) {
                // 2. 앞 번호와 뒤 번호 학생 모두가 체육복을 분실한 경우 - 앞 번호 학생에게 빌려준다.
                isLostList[i-1] = false;
                answer += 1;
            } else if(i-1 >= 0 && isLostList[i-1]) { 
                // 3. 앞 번호 학생만 분실한 경우
                isLostList[i-1] = false;
                answer += 1;
            } else if(i+1 < n && isLostList[i+1]) { 
                // 4. 뒷 번호 학생만 분실한 경우
                isLostList[i+1] = false;
                answer += 1;
            } else {
                // 5. 그 외 - 아무도에게 빌려줄 필요가 없는 경우
                continue;
            }
        }
        return answer;
    }
}
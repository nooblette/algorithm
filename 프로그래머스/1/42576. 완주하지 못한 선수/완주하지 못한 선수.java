import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 참여 선수 이름 추가
        Map<String, Integer> m = new HashMap<>();
        for(String p : participant) {
            m.put(p, m.getOrDefault(p, 0) + 1);
        }
        
        // 완주한 선수 이름 제거
        for(String c : completion) {
            int left = m.get(c);
            left -= 1;

            // 값을 -1씩 업데이트하다가 0이되면 해시테이블에서 제거하도록 하였다.
            if(left == 0) {
                m.remove(c);
            } else {
                m.put(c, left);
            }
        }
        
        // 남아있는 유일한 키(이름) 반환
        return m.entrySet().iterator().next().getKey();
    }
}
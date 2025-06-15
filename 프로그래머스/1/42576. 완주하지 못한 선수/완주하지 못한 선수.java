import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 완주한 사람들 목록
        Map<String, Integer> completionMap = new HashMap<>();
        
        // 완주한 사람들의 목록 이름과 갯수(동명이인) 초기화
        for(String name : completion) {
            int count = completionMap.getOrDefault(name, 0) + 1;
            completionMap.put(name, count);
        }
        
        for(String name : participant) {
            // 완주한 사람 목록에 없다면 정답 반환
            if(!completionMap.containsKey(name)) {
                return name;
            }
            
            // 완주한 사람 목록에 있으나 등장 횟수가 0이라면 정답 반환
            if(completionMap.get(name) == 0) {
                return name;
            }
            
            // 완주한 사람 목록에 있다면 카운트 감소
            completionMap.put(name, completionMap.get(name) - 1);
        }
        
        return "";
    }
}
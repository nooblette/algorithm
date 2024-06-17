import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> cheolsooToppingAndCount = new HashMap<>();
        Map<Integer, Integer> broToppingAndCount = new HashMap<>();
        
        // 철수 초기화
        int cheolsooKindCount = 1;
        cheolsooToppingAndCount.put(topping[0], 1);

        // 동생 초기화
        int broKindCount = 0;
        for(int i = 1; i < topping.length; i++){
            int count = 1;
            if(broToppingAndCount.containsKey(topping[i])){
                count = broToppingAndCount.get(topping[i]) + 1;
            } else {
                // 토핑 종류가 증가하는 경우 (기존 Map에 해당하는 key 값이 없는 경우)
                broKindCount += 1;
            }
            
            broToppingAndCount.put(topping[i], count);
        }
        
        for(int cuttingIndex = 1; cuttingIndex < topping.length; cuttingIndex++){
            // 철수 롤케이크 조각 얻기
            int count = 1;
            if(cheolsooToppingAndCount.containsKey(topping[cuttingIndex])){
                count = cheolsooToppingAndCount.get(topping[cuttingIndex]) + 1;
            } else {
                // 철수의 토핑 종류가 증가하는 경우 (기존 Map에 해당하는 key 값이 없는 경우)
                cheolsooKindCount += 1;
            }
            cheolsooToppingAndCount.put(topping[cuttingIndex], count);
            
            // 동생 롤케이크 조각 뺏기
            int broCount = broToppingAndCount.get(topping[cuttingIndex]) - 1;
            if(broCount == 0){
                // 특정 토핑의 마지막 조각인 경우
                broKindCount -= 1;
            }
            broToppingAndCount.put(topping[cuttingIndex], broCount);
            
            if(cheolsooKindCount == broKindCount) {
                answer += 1;
            }
        }
        return answer;
    }
}
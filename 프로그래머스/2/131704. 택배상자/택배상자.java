import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 컨테이너 벨트 초기화
        int[] box = new int[order.length];
        for(int i = 0; i < order.length; i++){
            box[i] = i + 1;
        }
        
        // 보조 컨테이너 벨트 선언
        Stack<Integer> spareContainer = new Stack<>();
        
        int answer = 0;
        int orderIndex = 0;
        int boxIndex = 0;

        while(true){
            // 상자를 실을 수 있는 경우 - 컨테이너 벨트의 상자 숫자와 택배 기사님의 순서가 동일한 경우
            while(boxIndex < order.length && orderIndex < order.length && box[boxIndex] == order[orderIndex]){
                answer += 1;
                orderIndex += 1;
                boxIndex += 1;
            }
            
            // 상자를 실을 수 있는 경우 - 보조 컨테이너 벨트의 가장 마지막 상자 숫자와 택배 기사님의 순서가 동일한 경우
            while(orderIndex < order.length && !spareContainer.isEmpty() && spareContainer.peek() == order[orderIndex]){
                spareContainer.pop();
                answer += 1;
                orderIndex += 1;
            }

            // 상자를 실을 수 없는 경우
            if(boxIndex == order.length) {
                break;
            }
            spareContainer.push(box[boxIndex]);
            boxIndex += 1;
        }
        
        return answer;
    }
}
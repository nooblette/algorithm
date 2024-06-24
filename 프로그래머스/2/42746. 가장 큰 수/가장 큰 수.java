import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 1. 정수 배열을 문자열 배열로 변환
        String[] numbersByStringType = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        // 2. 문자열 배열을 특정한 기준으로 정렬, Comparator를 커스텀하게 정의한다.
        //  - 특정한 기준 : 두 문자열의 합이 큰 정수가 앞으로 온다
        //    (e.g. '9'와 '34'가 있다면 '9', '34' 순서로 정렬한다. (934 > 349)
        
        // Array.sort() 메서드 시그니쳐 : 첫번째 매개변수 - 정렬 대상 배열, 두번째 매개변수 : 정렬 기준(default = 오름차순)
        // compareTo() : 음수를 반환하면 obj1, obj2 순으로 정렬한다 / 양수를 반환하면 obj2, obj1 순으로 정렬한다.
        Arrays.sort(numbersByStringType, (obj1, obj2) -> (obj2 + obj1).compareTo(obj1 + obj2));

        StringBuilder sb = new StringBuilder();
        for(String number : numbersByStringType) {
            sb.append(number);
        }
        
        // 3. 예외 처리 - 0이 여러개인 경우
        if(sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
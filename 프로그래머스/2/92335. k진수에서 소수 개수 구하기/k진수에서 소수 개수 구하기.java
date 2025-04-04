import java.util.*;
import java.lang.StringBuilder;

class Solution {
    public int solution(int n, int k) {
        // k진수로 변환한 결과를 얻기 위해 스택에 저장
        Deque<Integer> stack = new ArrayDeque<>();
        int remainder;
        while(n != 0) {
            remainder = n % k;
            n = n / k;
            stack.push(remainder);
        }

        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){ 
            sb.append(stack.pop());
        }
        
        int answer = 0;

        // k진수로 변환한 문자열 분리
        for(String s : sb.toString().split("0")) {
            // 문자열이 00인 경우 예외 처리
            if(s.equals("")) {
                continue;
            }

            // 각 문자열에 대해 소수 여부를 판별
            if(isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
	private boolean isPrime(long num) {
		// 1은 소수도 합성수도 아님
		if(num == 1) {
			return false;
		}
			
		// 짝수인 경우 false
		if(num != 2 && num % 2 == 0) {
			return false;
		}
			
		// √n까지만 반복, 짝수는 위에서 검증했으므로 i는 2씩 증가
		for(int i = 3; i <= Math.sqrt(num); i+= 2) {
			// 소수는 1과 자기 자신만을 약수로 갖는다.
			// 만약 다른 수로 나누어 떨어진다면 소수가 아니므로 false를 반환한다.
			if(num % i == 0) {
				return false;
			}
		}
			
		return true;
	}    
}
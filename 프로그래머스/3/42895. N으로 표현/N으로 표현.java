import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) {
            return 1;
        }
        
        // dp[i] = N을 i번 사용해서 만들 수 있는 숫자 집합을 저장
        // (dp[i]가 i를 만드는데 필요한 N의 개수가 아닌 N의 목록(집합) 자체를 담고있는 것이 핵심)
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); // dp.get(0)
        dp.add(Set.of(N)); // dp.get(1)

        for(int i = 2; i < 9; i++){
            Set<Integer> numSet = new HashSet<>();
            
            // 같은 숫자 반복해서 만드는 경우
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            numSet.add(repeatedNum);
            
            for(int j = 1; j < i; j++){
                Set<Integer> op1Set = dp.get(i - j);
                Set<Integer> op2Set = dp.get(j);
                
                for(Integer op1 : op1Set) {
                    for(Integer op2 : op2Set) {
                        if(op2 != 0) {
                            numSet.add(op1 / op2);
                        }
                        
                        numSet.add(op1 + op2);
                        numSet.add(op1 - op2);
                        numSet.add(op1 * op2);
                    }
                }
            }
            
            if(numSet.contains(number)) {
                return i;
            }
            dp.add(numSet);
        }
        return -1;
    }
}
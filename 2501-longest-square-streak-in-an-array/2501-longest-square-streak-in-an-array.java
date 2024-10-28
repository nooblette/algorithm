class Solution {
    public int longestSquareStreak(int[] nums) {
        int answer = -1;
        // 원소 정렬 - 효율적인 탐색을 위함
        Arrays.sort(nums);
        
        // Set 자료구조를 통해 탐색을 효율적으로 개선한다. (원소 조회와 제거가 O(1))
        Set<Long> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add((long) num);
        }
        
        for(int num : nums) {
            // 이미 사용한 숫자는 넘어간다.
            if(!numSet.contains((long) num)) {
                continue;
            }
            
            int len = 1;
            long current = num;
            
            // Set을 탐색하며 제곱수를 찾는다.
            while(numSet.contains(current * current)) {
                // current 갱신
                current = current * current;
                
                // Set에서 제거 (탐색 효율화를 위함)
                numSet.remove(current);
                
                // 길이 증가
                len += 1;
            }
            
            // 길이 갱신
            answer = answer > len ? answer : len;
        }
        
        return answer > 1 ? answer : -1;
    }
}
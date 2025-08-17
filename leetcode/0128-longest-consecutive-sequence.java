class Solution {
    public int longestConsecutive(int[] nums) {
        // 특정 값을 빠르게 확인하기 위해 HashSet으로 변환
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }

        // 연속 수열 탐색
        int result = 0;
        for(int num : numSet) {
            // 연속 수열의 중간 부분인 경우
            if(numSet.contains(num - 1)) {
                continue;
            }

            // 연속 수열의 시작 지점인 경우
            int curNum = num;
            int curLen = 1;

            // 연속 수열의 길이 계산
            while(numSet.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }

            result = Math.max(result, curLen);
        }

        return result;
    }
}

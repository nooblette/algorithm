class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 특정 원소와 등장하는 횟수 저장
        Map<Integer, Boolean> seen = new HashMap<>();

        for(int num : nums) {
            // 등장한 적이 있다면 true 반환
            if(seen.containsKey(num)) {
                return true;
            }

            // 등장한 적이 없다면 Map에 추가
            seen.put(num, true)
        }

        // 정답을 찾지 못한 경우 false 반환
        return false;
    }
}

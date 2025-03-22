class Solution {
    public int majorityElement(int left, int right, int[] nums) {
        // 최소 분할 단위 리턴
        if(left == right) {
            return nums[left];
        }
        
        // 중앙 위치 인덱스 계산
        final int mid = left + (right - left) / 2;
        
        // 분할 한 배열에서 가장 빈도수가 높은 엘리먼트 추출
        final int a = majorityElement(left, mid, nums);
        final int b = majorityElement(mid + 1, right, nums);
        
        // 과반이 넘는 엘리먼트 반환
        int countA = 0;
        for(int i = left; i <= right; i++) {
            if(nums[i] == a) {
                countA++;
            }
        }
        
        // 과반이 넘는 엘리먼트를 반환
        return countA > (right - left + 1) / 2 ? a : b;
    }
    public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length - 1, nums);
    }
}
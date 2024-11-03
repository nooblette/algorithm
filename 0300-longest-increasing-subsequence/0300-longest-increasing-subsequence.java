class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // 증가하는 부분 수열 값을 저장할 배열
        List<Integer> LIS = new ArrayList<>();
        
        for(int num : nums) {
            // `binarySearch()` : 특정 원소의 인덱스를 반환한다.
            // 만약 리스트에 해당 원소가 없다면, 리스트에 추가했을때 정렬이 유지되는 인덱스 + 1한 값을 음수로 반환한다.
            int pos = Collections.binarySearch(LIS, num);
            
            if(pos < 0) {
                // 이분탐색을 이용하여 저장 위치 탐색
                pos = -(pos + 1);
            }
            
            // 증가하는 부분 수열을 유지하는 경우 - 리스트 가장 뒤에 추가한다.
            if(pos == LIS.size()) {
                LIS.add(num);
            } else {
                // 증가하는 부분 수열을 유지할 수 없는 경우 - 부분 수열을 유주힐 수 있도록 리스트의 원소를 변경한다.
                LIS.set(pos, num);
            }
        }
        
        return LIS.size();
    }
}
class Solution {
    public int arrayPairSum(int[] nums) {
        // nums 배열 정렬
        Arrays.sort(nums);
        
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        
        // 앞에서부터 오름차순 반복
        for(int n : nums) {
            pair.add(n);
            
            // 페어 변수에 값이 2개 채워지면 min 값을 구하고 sum에 추가
            if(pair.size() == 2){
                sum += Collections.min(pair);
                
                // pair 초기화
                pair.clear();
            }
        }
        
        return sum;
    }
}
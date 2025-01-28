class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 배열 순회
        for(int i = 0; i < numbers.length; i++) {
            // target에서 현재 순회중인 원소의 값을 뺀다
            int expected = target - numbers[i];
            
            // 이진 검색으로 expected가 numbers 배열에 있는지 탐색
            int idx = Arrays.binarySearch(numbers, i + 1, numbers.length, expected);
            // 있다면 결과로 반환
            if(idx >= 0) {
                return new int[]{i + 1, idx + 1};
            }
        }
        
        return null;
    }
}
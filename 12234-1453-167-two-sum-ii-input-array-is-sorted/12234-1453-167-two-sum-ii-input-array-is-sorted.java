class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 왼쪽 포인터는 가장 좌측 지정
        int left = 0;

        // 오른쪽 포인터는 가장 우측 지정
        int right = numbers.length - 1;

        // 왼쪽 포인터가 오른쪽 포인터보다 작다면 계속 탐색
        while(left < right) {
            // 합이 target보다 작으면 왼쪽 포인터를 한 칸 증가
            if(numbers[left] + numbers[right] < target) {
                left++;
            } else if(numbers[left] + numbers[right] > target) {
                // 합이 target보다 크다면 오른쪽 포인터를 한 칸 감소
                right--;
            } else {
                // 합이 target과 같다면 정답을 찾았으니 반환
                return new int[]{left + 1, right + 1};
            }
        }
        
        return null;
    }
}
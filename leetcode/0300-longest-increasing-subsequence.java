class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // 인덱스별로 가능한 가장 작은 원소들로 이루어진 부분 수열 배열 선언
        // BinarySearch 대상 배열이 된다.
        List<Integer> subsequence = new ArrayList<>();

        for(int num : nums) {
            // 현재 원소 num이 부분 수열 배열에 들어갈 위치 탐색
            int pos = binarySearch(subsequence, num);

            // 부분 수열 배열의 모든 원소가 현재 원소보다 작다면 배열에 새로 추가
            if(pos == subsequence.size()) {
                subsequence.add(num);
            } else {
                // 부분 수열 배열 중 현재 원소보다 큰 값이 있다면, 현재 원소보다 크거나 같은 첫번째 값을 현재 원소로 교체  
                subsequence.set(pos, num);
            }
        }

        // 부분 수열 배열의 최종 길이를 반환
        return subsequence.size();
    }

    private int binarySearch(List<Integer> subsequence, int target) {
        int left = 0;
        int right = subsequence.size();

        while(left < right) {
            int mid = left + (right - left) / 2;

            // target이 탐색하는 배열의 중앙보다 우측에 있다면
            if(subsequence.get(mid) < target) {
                // 시작 지점을 변경
                left = mid + 1;
            } else {
                // target이 탐색하는 배열의 중앙보다 좌측에 있다면
                // 종료 지점을 변경
                right = mid;
            }
        }

        // target이 들어갈 위치를 반환
        return left;

    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 인덱스가 아닌 값 자체를 사용
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums) {
            // first보다 작거나 값은 값이 나온다면 갱신한다.
            // second는 갱신 이전 fisrt에 대해 fisrt < second를 만족하는 유효한 값일 수 있다.
            // 따라서 다음 num에 대해 increasingTriplet을 만족할 수 있으므로 초기화하면 안된다. (이전 탐색 결과를 기록하고 있어야한다.)
            if(num <= first) {
                first = num;
            } else if(num <= second) {
                // first < num <= second를 만족하는 경우, fisrt < second를 유지하기 위해 second를 num으로 갱신한다.
                second = num;
            } else {
                // first < second < num을 만족하는 경우, increasingTriplet를 찾았으므로 true 반환
                return true;
            }
        }

        // 도중에 increasingTriplet을 찾지 못했다면 false 반환
        return false;
    }
}

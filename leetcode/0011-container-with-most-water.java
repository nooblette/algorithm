class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int answer = 0;
        while(left < right) {
            answer = Math.max(answer, (right - left) * Math.min(height[left], height[right]));

            // 컨테이너의 물의 양을 높이가 낮은 벽에 의해 결정된다.
            // 따라서 left와 right 중 hieght가 낮은 지점을 이동한다.
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}

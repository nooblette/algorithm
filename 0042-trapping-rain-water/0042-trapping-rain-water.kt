class Solution {
    fun trap(height: IntArray): Int {
        var volume = 0
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]
        
        while(left <= right) {
            leftMax = height[left].coerceAtLeast(leftMax)
            rightMax = height[right].coerceAtLeast(rightMax)
            
            if(leftMax <= rightMax) {
                // 왼쪽 막대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left]
                left += 1
            } else {
                volume += rightMax - height[right]
                right -= 1
            }
        }
        
        return volume
        
    }
}
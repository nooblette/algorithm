class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        
        // 왼쪽 곱셈
        var p = 1
        for(i in nums.indices) {
            result[i] = p
            p *= nums[i]
        }
        
        // 오른쪽 곱셈
        p = 1
        for(i in nums.indices.reversed()) {
            result[i] *= p
            p *= nums[i]
        }
        
        return result
    }
}
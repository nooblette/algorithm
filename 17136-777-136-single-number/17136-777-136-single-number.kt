class Solution {
    fun singleNumber(nums: IntArray): Int = nums.fold(0) { acc, num -> acc xor num }
}

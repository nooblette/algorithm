class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        var sum = 0
        nums.sort()
        
        // 앞에서부터 오름차순으로 인덱스 반복
        for((i, n) in nums.withIndex()) {
            // 짝수번째일때 합 계산
            if(i % 2 == 0) {
                sum += n
            }
        }
        
        return sum
    }
}
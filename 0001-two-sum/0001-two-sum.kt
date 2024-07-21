class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap: MutableMap<Int, Int> = mutableMapOf()
        
        // 하나의 for문으로 통합
        for((i, num) in nums.withIndex()) {
            // target에서 num을 뺀 값이 있으면 정답으로 반환
            if(numsMap.containsKey(target - num)) {
                return intArrayOf(numsMap[target - num] ?: 0, i)
            }
            // 정답이 아니라면 값과 인덱스를 맵에 저장
            numsMap[num] = i
        }
        
        // 항상 정답이 존재하므로 반환하는 경우는 없음
        return intArrayOf(0, 0)
    }
}
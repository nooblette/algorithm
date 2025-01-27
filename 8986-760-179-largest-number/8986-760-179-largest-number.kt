class Solution {
    fun toSwap(n1: Int, n2: Int): Boolean {
        // 두 숫자를 결합한 문자열을 비교 (사전순 비교)
        val s1 = n1.toString() + n2
        val s2 = n2.toString() + n1
        
        return s1 < s2
    }
    
    fun largestNumber(nums: IntArray): String {
        // 정렬이 필요한(삽입 위치를 찾는) 인덱스
        var i = 1
        
        while(i < nums.size) {
            // 이미 정렬한 인덱스
            var j = i
            
            while(j > 0 && toSwap(nums[j - 1], nums[j])) {
                nums[j - 1] = nums[j].also { nums[j] = nums[j-1] }
                j--
            }
            
            i++
        }
        
        return if(nums[0] == 0) {
            "0"
        } else {
          nums.contentToString().replace("\\[|\\]|\\,|\\s".toRegex(), "")  
        }
    }
}
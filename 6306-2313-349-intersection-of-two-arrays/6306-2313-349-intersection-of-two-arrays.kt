class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        val result: MutableSet<Int> = HashSet()
        
        // 한쪽 정렬
        Arrays.sort(nums2)
        
        // 다른 한쪽 탐색
        for(num1 in nums1) {
            if(Arrays.binarySearch(nums2, num1) >= 0) {
                result.add(num1)
            }
        }
        
        // IntArray로 변환하여 반환
        return result.toIntArray()
    }
}

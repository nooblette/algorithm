class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // 배열 순회
        for(i in numbers.indices) {
            // target에서 현재 순회중인 원소의 값을 뺀다
            val expected = target - numbers[i]
            
            // 이진 검색으로 expected가 numbers 배열에 있는지 탐색
            val idx = Arrays.binarySearch(numbers, i + 1, numbers.size, expected)
            
            // 있다면 결과로 반환
            if(idx >= 0) {
                return intArrayOf(i + 1, idx + 1)
            }
        }
        
        return intArrayOf()
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        
        // 이진 검색으로 탐색
        Arrays.sort(nums2);
        for(int num1 : nums1) {
            if(Arrays.binarySearch(nums2, num1) >= 0) {
                result.add(num1);
            }
        }
        
        // HashSet()을 int[]로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
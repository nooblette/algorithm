class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        
        // 두 집합 탐색
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                if(num1 == num2) {
                    result.add(num1);
                }
            }
        }
        
        // HashSet()을 int[]로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
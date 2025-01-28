class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        
        // 두 배열 정렬
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // 투 포인터 선언
        int i = 0;
        int j = 0;
        
        while(i < nums1.length && j < nums2.length) {
            // 값이 작은 쪽의 포인터가 앞으로 이동
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums2[j] < nums1[i]) {
                j++;
            } else {
                // 값이 일치하는 경우 결과 삽입 후 포인터 모두 이동
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
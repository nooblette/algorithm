class Solution {
    public boolean toSwap(int n1, int n2) {
        // 두 숫자를 결합한 문자열을 비교 (사전순 비교)
        String s1 = String.valueOf(n1) + n2;
        String s2 = String.valueOf(n2) + n1;
        return s1.compareTo(s2) < 0; // 사전순으로 비교
    }
    
    public String largestNumber(int[] nums) {
        // 정렬이 필요한(삽입 위치를 찾는) 인덱스
        int i = 1;

        // 정렬할 인덱스
        while(i < nums.length) {
            // 이미 정렬한 인덱스
            int j = i;

            // nums[j]보다 nums[i]가 크다면 위치를 바꾼다.
            while(j > 0 && toSwap(nums[j - 1], nums[j])) {
                int tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;

                j--;
            }

            i++;
        }
        
        if(nums[0] == 0) {
            return "0";
        } else {
            return Arrays.toString(nums).replaceAll("\\[|\\]|\\,|\\s", "");
        }
    }
}
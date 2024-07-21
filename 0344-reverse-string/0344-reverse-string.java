class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        // 서로 중앙으로 이동하면서 겹치는 지점에 도달하면 종료
        while(start < end) {
            // 임시 변수를 이용해 값 스왑
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            // 인덱스 이동
            start++;
            end--;
        }
    }
}
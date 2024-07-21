class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        // 자료 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while(start < end) {
            // 영숫자인지 판별, 유효하지 않으면 한 칸 이동한다.
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else {
                // 하나라도 일치하지 않으면 팰린드롬이 아니므로 false 반환
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                
                // 팰린드롬이 맞다면 다음 인덱스에 대해 반복 진행
                start++;
                end--;
            }
        }
        // 무사히 종료한 경우, true 반환
        return true;
    }
}
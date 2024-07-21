class Solution {
    public boolean isPalindrome(String s) {
        // 정규표현식으로 영숫자만을 걸러낸다.
        String filtered_s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 문자열을 뒤집는다.
        String revesed_filtered_s = new StringBuilder(filtered_s).reverse().toString();
        // 팰린드롬 검증
        return filtered_s.equals(revesed_filtered_s);
    }
}
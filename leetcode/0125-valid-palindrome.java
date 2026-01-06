class Solution {
    public boolean isPalindrome(String s) {
        // 영문과 숫자가 아닌 모든 문자를 제거하고 소문자로 치환
        String replacedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 뒤집은 문자열과 서로 동일한지 비교
        String reversedString = new StringBuilder(replacedString).reverse().toString();

        System.out.println(replacedString);
        System.out.println(reversedString);
        return replacedString.equals(reversedString);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        // 두 문자열의 길이가 다른 경우 Anagram자체가 불가능하므로 예외 처리
        if(s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);

        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }
}

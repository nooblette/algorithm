class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        // 문자열 s를 구성하는 문자를 기준으로 확장하여 최장 길이의 팰린드롬인 부분 문자열을 구한다.
        // 문자열 s를 구성하는 문자는 n개, 길이가 n인 문자열의 팰린드롬 여부 판별은 n개의 모든 문자를 탐색해야한다.
        // 모든 중심 문자를 기준으로 확장하며 각 중심 문자별로 팰린드롬 여부를 판단하여 최장 길이를 탐색하므로 시간 복잡도는 O(n^2)이 된다.
        for(int i = 0; i < s.length(); i++) {
            // 각 문자를 중심으로 팰린드롬 여부를 판별하여 최장 길이 갱신

            // 부분 문자열의 길이가 홀수인 경우, 문자열 1개를 기준으로 확장하며 팰린드롬 여부와 그 떄의 길이를 판별한다.
            int len1 = calculatePalindromeLength(s, i, i);

            // 부분 문자열의 길이가 짝수인 경우, 문자열 2개를 기준으로 확장한다.
            int len2 = calculatePalindromeLength(s, i, i + 1);

            // 둘 중 큰 값을 취한다.
            int len = Math.max(len1, len2);

            // 부분 문자열 반환을 위한 인덱스(투 포인터) 갱신
            if(len > right - left + 1) {
                // i는 중심 인덱스이므로 len / 2만큼 좌우로 확장하여 투 포인터를 갱신한다.
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        // substring(a, b)은 문자열의 [a, b) 범위에 해당하는 부분 문자열을 구하므로 두번째 파라미터에 + 1을 취한다.
        return s.substring(left, right + 1);
    }

    private int calculatePalindromeLength(String s, int left, int right) {
        // 양 끝 문자가 동일하면서 길이를 확장할 수 있는 동안 두 개의 포인터를 이동
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 팰린드롬의 길이 반환
        // while loop에서 두 개의 포인터는 이동하고 나서 양 끝 문자가 동일하거나 문자열 s의 길이 내에 있는지 판단한다.
        // 즉 while loop를 빠져나올 떄는 유효하지 않은 위치를 가리키므로 각각 한 칸씩 중앙으로 이동하고 반환한다.
        return right - left - 1; // (right - 1) - (left + 1) + 1
    }
}

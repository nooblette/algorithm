class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = s.substring(0, i)를 wordDict으로 만들 수 있는지 여부 저장
        boolean[] dp = new boolean[s.length() + 1];

        // 빈 문자열은 항상 만들 수 있다.
        dp[0] = true;

        for(int i = 0; i < s.length(); i++) {
            // 현재 위치까지 만들 수 있다면
            if(dp[i]) {
                for(String word : wordDict) {
                    int endPos = i + word.length();

                    // 주어진 단어 사전의 단어로 이후 위치(i + word.lenth())까지의 부분 문자열도 만들 수 있는지 판별
                    if(endPos <= s.length() && s.substring(i, endPos).equals(word)) {
                        // 이후 위치가 여전히 문자열 s의 범위내에 있고 s의 서브 스트링을 단어사전으로 만들 수 있다면 endPos 위치까지도 만들 수 있다
                        dp[endPos] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}

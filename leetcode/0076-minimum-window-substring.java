class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        // t를 구성하는 문자와 개수 저장
        Map<Character, Integer> charAndCount = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = t.charAt(i);
            charAndCount.put(c, charAndCount.getOrDefault(c , 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int left = 0;
        int right = 0;

        // t의 모든 문자를 포함하는 subString을 만들기 위해 찾아야하는 문자의 개수
        int remainCharCount = n;

        // t의 모든 문자를 포함하는 subString을 만들 수 있을때까지 right를 증가한다.
        while(right < m) {
            char c = s.charAt(right);
            if(charAndCount.containsKey(c)) {
                if(charAndCount.get(c) > 0) {
                    remainCharCount--;
                }
                charAndCount.put(c, charAndCount.get(c) - 1);
            }
            right++;

            // t의 모든 문자를 포함하는 subString을 만들 수 있는 동안 left를 증가한다. (최소 길이 찾기)
            while(remainCharCount == 0) {
                // 결과 갱신
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                if(charAndCount.containsKey(s.charAt(left))){
                    charAndCount.put(s.charAt(left), charAndCount.get(s.charAt(left)) + 1);

                    // left 문자를 윈도우에서 제거하면 조건을 만족할 수 없는 경우 right를 다시 늘려 탐색해야함
                    if(charAndCount.get(s.charAt(left)) > 0) {
                        remainCharCount++;
                    }
                }

                // left 문자를 윈도우에서 제거
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen - 1);
    }
}

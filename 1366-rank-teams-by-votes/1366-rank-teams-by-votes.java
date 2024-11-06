class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length(); // 투표 인원
        
        // key는 후보자, value는 랭킹을 인덱스로 해당 랭킹 달성 횟수를 갖는다.
        Map<Character, int[]> map = new HashMap<>();
        
        // map 초기화
        for(String vote : votes) {
            for(int i = 0; i < n; i++) {
                // 해당하는 후보자의 랭킹 달성 횟수 배열이 없다면 초기화
                map.putIfAbsent(vote.charAt(i), new int[n]);
                
                // 후보자의 랭킹 달성 횟수 배열 조회
                int[] rankingAndCount = map.get(vote.charAt(i));
                
                // 후보자의 랭킹 달성 횟수 증가
                rankingAndCount[i] += 1;
            }
        }
        
        // 후보자 이름만으로 리스트 생성
        List<Character> candidates = new ArrayList<>(map.keySet());
        
        // map의 value를 기준으로 리스트 정렬
        candidates.sort((c1, c2) -> {
            for(int i = 0; i < n; i++) {
                if(map.get(c1)[i] == map.get(c2)[i]) {
                    // i 순위 달성 횟수가 동일하다면 다음 순위(i+1) 달성 횟수로 비교한다.
                    continue;
                }
                
                // i 순위 달성 횟수가 다르다면 많이 달성한 횟수를 기준으로 내림차순 정렬
                return map.get(c2)[i] - map.get(c1)[i];
            }
                
            // 모든 순위 횟수가 동일하다면 알파벳순 정렬
            return c1 - c2;
        });
        
        // 후보자 이름 리스트를 문자열로 조합하여 반환
        StringBuilder sb = new StringBuilder();
        for(char candidate : candidates) {
            sb.append(candidate);
        }
        
        return sb.toString();
    }
}
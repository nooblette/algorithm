import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 각 유저별로 자기 자신을 신고한 신고자 목록을 만든다. 메일 보내는 사용자를 추출할때 사용한다.
        // key : 이용자 id, value : key를 신고한 이용자 id 목록
        Map<String, List<String>> reportLog = new HashMap<>();
        for(String r : report) {
            // 공백을 기준으로 분리
            String[] person = r.split(" ");

            // 단 한 유저를 여러번 신고할 수도 있지만 동일한 유저에 대한 신고 횟수는 1회로 처리된다. 처리
            if(reportLog.containsKey(person[1]) && reportLog.get(person[1]).contains(person[0])) {
                continue;
            }
            
            // person[0] : 신고한 사람, person[1] : 신고 당한 사람
            List<String> reporters = reportLog.getOrDefault(person[1], new ArrayList<>());
            reporters.add(person[0]);
            reportLog.put(person[1], reporters);
        }
        
        // reportLog를 메일을 보낼 사용자 목록으로 변환한다.
        // key : 이용자 id, value : 메일을 받을 횟수
        Map<String, Integer> mailCounts = new HashMap<>();
        for(Map.Entry<String, List<String>> log : reportLog.entrySet()) {
            if(log.getValue().size() >= k) {
                for(String person : log.getValue()) {
                    mailCounts.put(person, mailCounts.getOrDefault(person, 0) + 1);
                }
            }
        }
        
        // 이용자 별로 메일을 받을 횟수를 담은 해시 테이블 mailCounts를 value를 기준으로 배열로 변환하여 반환한다.
        return Arrays.stream(id_list)
            .mapToInt(id -> Integer.valueOf(mailCounts.getOrDefault(id, 0)))
            .toArray();
    }
}
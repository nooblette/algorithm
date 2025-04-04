import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량별 출입 내역을 관리
        Map<String, Integer> parkingLogs = new HashMap<>();

        // 차랑별 누적 주차 시간을 보관
        Map<String, Integer> parkingTimes = new HashMap<>();
        
        // 차량별 누적 주차 시간 계산
        for(String record : records) {
            String[] log = record.split(" ");

            // 시간 기록 추출
            String[] time = log[0].split(":");

            // 입차 기록인 경우
            if("IN".equals(log[2])) {
                // parkingLogs에 입차 기록 추가
                parkingLogs.put(log[1], Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            } else if("OUT".equals(log[2])) {
                // 출차 기록인 경우
                // parkingLogs에서 입차한 시간을 꺼내고 누적 주차 시간을 계산
                int elapsedTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - parkingLogs.get(log[1]);

                // 누적 주차 시간 적재
                parkingTimes.put(log[1], parkingTimes.getOrDefault(log[1], 0) + elapsedTime);

                // parkingLogs에 입차 기록 제거
                parkingLogs.remove(log[1]);
            }
        }
            
        // 23:59 출차 처리
        for(Map.Entry<String, Integer> parkingLog : parkingLogs.entrySet()) {
            parkingTimes.put(parkingLog.getKey(), parkingTimes.getOrDefault(parkingLog.getKey(), 0) + 23 * 60 + 59 - parkingLog.getValue());
        }
            
        // 차량번호 기준으로 정렬
        // 누적 주차 시간에서 Key(차량 번호)를 기준으로 오름차순 정렬한다.
        List<String> parkingTimesByKey = new ArrayList<>(parkingTimes.keySet());
        parkingTimesByKey.sort(Comparator.comparingInt(Integer::parseInt));
            
        // 차량별 누적 금액 추출
        int[] answer = new int[parkingTimesByKey.size()];

        // 정렬된 차량번호 목록을 순회
        int i = 0;
        for(String k : parkingTimesByKey) {
            // 차량 번호마다 누적 주차 시간 추출

            // 기본 시간보다 적은 경우
            if(parkingTimes.get(k) < fees[0]) {
                answer[i++] = fees[1];
             } else {
                answer[i++] = fees[1] + (int) Math.ceil((parkingTimes.get(k) - fees[0]) / (double) fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}
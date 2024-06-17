import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        String[] parkingLot = new String[10000]; // 주차장
        Arrays.fill(parkingLot, "x");
        
        Map<String, Integer> totalParkingTime = new HashMap<>(); // 차량별 누적 주차 시간
        for(String record : records){
            String[] infos = record.split(" ");
            String time = infos[0];
            String carNumber = infos[1];

            if("IN".equals(infos[2])){
                parkingLot[Integer.parseInt(carNumber)] = time;
            } else if("OUT".equals(infos[2])){
                String inTime = parkingLot[Integer.parseInt(carNumber)];
                String[] inHourAndMinute = inTime.split(":");
                String[] outHourAndMinute = time.split(":");
                
                // 누적 주차 시간(분) 계산
                int diffHour = Integer.parseInt(outHourAndMinute[0]) - Integer.parseInt(inHourAndMinute[0]);
                int diffMinute = Integer.parseInt(outHourAndMinute[1]) - Integer.parseInt(inHourAndMinute[1]);
                if(diffMinute < 0) {
                    diffHour -= 1;
                    diffMinute = 60 + diffMinute;
                }
                int accumParkingTime = diffHour * 60 + diffMinute;
                
               
                int count = accumParkingTime;
                if(totalParkingTime.containsKey(carNumber)){
                    count += totalParkingTime.get(carNumber);
                }
                totalParkingTime.put(carNumber, count); // 누적 주차 시간 저장
                
                // 출차했으므로 차량의 입출차 기록을 초기화
                parkingLot[Integer.parseInt(carNumber)] = "x";
            }
        }
        
        // OUT 하지 않은 차량 처리
        for(int i = 0; i < parkingLot.length; i++){
            String inParkingTime = parkingLot[i];
            
            if("x".equals(inParkingTime)) {
                continue;                
            }
            
            // 누적 주차 시간(분) 계산
            String[] inHourAndMinute = inParkingTime.split(":");
            
            int diffHour = 23 - Integer.parseInt(inHourAndMinute[0]);
            int diffMinute = 59 - Integer.parseInt(inHourAndMinute[1]);
            
            int accumParkingTime = diffHour * 60 + diffMinute;
            String carNumber = String.format("%04d", i);
            
            int count = accumParkingTime;
            if(totalParkingTime.containsKey(carNumber)){
                count += totalParkingTime.get(carNumber);
            }
            totalParkingTime.put(carNumber, count); // 누적 주차 시간 저장
        }
       
        // 주차 요금 계산
        Map<String, Integer> carNumberAndTotalFee = new HashMap<>();
        for(Map.Entry<String, Integer> carNumberAndTime: totalParkingTime.entrySet()){
            Integer time = carNumberAndTime.getValue();
            String carNumber = carNumberAndTime.getKey();
            if(time <= defaultTime) {
                // 기본 시간 미만인 경우
                carNumberAndTotalFee.put(carNumber, Integer.valueOf(defaultFee));
                
            } else {
                // 기본 시간을 초과한 경우
                int overTime = time - defaultTime;
                double overFee = Math.ceil((double) overTime / (double) unitTime);
                carNumberAndTotalFee.put(carNumber, Integer.valueOf((int)(defaultFee + overFee * unitFee)));
            }
        }
        
        Map<String, Integer> sortedByCarNumber = new TreeMap<>(carNumberAndTotalFee);
        return sortedByCarNumber.values()
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
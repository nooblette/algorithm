class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 문자 로그를 지정할 문자 리스트
        List<String> letterList = new ArrayList<>();

        // 숫자 로그를 지정할 숫자 리스트
        List<String> digitList = new ArrayList<>();

        for(String log : logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
               
               
        // 문자 리스트 정렬
        letterList.sort((s1, s2) -> {
                String[] s1x = s1.split(" ", 2);
                String[] s2x = s2.split(" ", 2);

                // 식별자 외 나머지 부분 : 문자 로그 사전순 비교
                int compared = s1x[1].compareTo(s2x[1]);

                // 식별자 : 문자가 동일한 경우 식별자 비교
                if(compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    /*
                    * s1과 s2가 동일한 경우 0 반환
                    * s2가 앞으로 와야한다면 양수(1) 반환
                    * s2가 뒤에 머물러야 한다면 음수(-1)을 반환한다.
                    */
                    return compared;
                }
        });
        
        // 문자 리스트와 숫자 리스트 합치기, 조건 상 문자 리스트 뒤에 숫자 리스트가 온다.
        // 숫자 로그는 '입력 순서대로 한다'라는 조건이 있었으므로 따로 정렬하지 않는다.
        letterList.addAll(digitList);
        
        // 리스트를 String 배열로 변환해 리턴 (toArray())
        return letterList.toArray(new String[0]);

    }
}
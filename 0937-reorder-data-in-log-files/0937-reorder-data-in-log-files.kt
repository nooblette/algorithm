class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        // 문자 로그를 저장할 문자 리스트
        val letterList = mutableListOf<String>()
        
        // 숫자 로그를 저장할 숫자 리스트
        val digitList = mutableListOf<String>()
        
        for(log in logs) {
            if(Character.isDigit(log.split(" ")[1][0])) {
                digitList.add(log)
            } else {
                letterList.add(log)
            }
        }
        
        // 문자 리스트 정렬
        letterList.sortWith(Comparator { s1: String, s2: String ->
            // 식별자와 식별자 외 나머지 부분을 분리
            val s1x = s1.split(" ", limit = 2)
            val s2x = s2.split(" ", limit = 2)
            
            // 문자 로그 사전순 비교
            val compared = s1x[1].compareTo(s2x[1])
            if(compared == 0) {
                // 문자가 같다면 식별자를 비교
                s1x[0].compareTo(s2x[0])
            } else {
                // s1x[1]과 s2x[1]이 같다면 0, s1x[1]이 뒤에 와야한다면 1, s1x[1]가 앞에 머무른다면 -1을 반환
                compared
            }
        })
        
        // 문자 리스트 뒤로 숫자 리스트를 붙인다.
        // 숫자 로그는 '입력 순서대로'라는 제약조건이 있으므로 따로 정렬하지 않는다.
        letterList.addAll(digitList)
        
        // toTypedArray() : 리스트의 요소들을 동일한 타입의 배열로 변환하여 반환
        return letterList.toTypedArray()
    }
}
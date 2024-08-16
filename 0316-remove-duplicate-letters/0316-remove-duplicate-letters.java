class Solution {
    public Set<Character> toSortedSet(String s) {
        // 문자열을 문자 단위 집합(Set)으로 저장할 변수 선언
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            // 비교 메서드 재정의
            @Override
            public int compare(Character o1, Character o2) {
                if(o1 == o2) {
                    return 0;
                }

                // 새로운 문자(o1)가 기본 문자(o2)보다 크다면 뒤에 위치
                if(o1 > o2) {
                    return 1;
                }

                // 새로운 문자(o1)가 기본 문자(o2)보다 작다면 앞에 위치
                return -1;
            }
        });
        
        // 문자열을 문자 단위로 집합에 저장, 정렬된 상태로 저장한다.
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        return set;
    }
                                       
    public String removeDuplicateLetters(String s) {
        // 정렬된 문자열 집합 순회
        Set<Character> suffix = toSortedSet(s);
        for(char c : suffix) {
            String splitedSByC = s.substring(s.indexOf(c));
            
            // suffix의 가장 먼저오는 알파벳을 기준으로 s를 분리한 결과와 suffix와 같다면 정답으로 추출
            if(suffix.equals(toSortedSet(splitedSByC))) {
                return c + removeDuplicateLetters(splitedSByC.replace(String.valueOf(c), ""));
            }
        }
        
        return "";
    }
}
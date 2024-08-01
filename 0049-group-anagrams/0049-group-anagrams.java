class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애너그램 결과를 보관하기 위한 맵 선언
        Map<String, List<String>> results = new HashMap<>();
        
        // 입력값인 문자열 배열을 순회
        for(String str: strs){
            // 문자열을 문자 배열로 변환
            char[] chars = str.toCharArray();
            
            // 문자 배열 정렬
            Arrays.sort(chars);
            
            // 문자 배열을 문자열로 변환(results 맵의 key로 사용)
            String key = String.valueOf(chars);
            
            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            if(!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            
            // 키에 해당하는 리스트 추가
            results.get(key).add(str);
        }
        
        // 문제에서 요구하는 형태(List<List<String>>)로 반환
        return new ArrayList<>(results.values());
    }
}
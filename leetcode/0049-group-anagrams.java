class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Anagram 여부를 판단하기 위해 각 문자열을 정렬한 결과를 key, 각 문자열을 value로 갖는 Map 선언
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // 정렬한 문자열 생성
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String ordered = new String(strArray);

            // 문자열 목록 추가
            List<String> soruces = map.getOrDefault(ordered, new ArrayList<>());
            soruces.add(str);

            // Map 갱신
            map.put(ordered, soruces);
        }

        return new ArrayList<>(map.values());
    }
}

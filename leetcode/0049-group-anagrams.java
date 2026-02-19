class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 정렬된 문자열을 key, 값 목록을 value로 갖는 Map
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sorted = String.valueOf(chars);

            List<String> values = map.getOrDefault(sorted, new ArrayList<>());
            values.add(str);
            map.put(sorted, values);
        }

        return new ArrayList<>(map.values());
    }
}

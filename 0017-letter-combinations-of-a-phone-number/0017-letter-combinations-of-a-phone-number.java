class Solution {
    public void dfs(
        List<String> result,
        Map<Character, List<Character>> dic, 
        String digits,
        int index,
        StringBuilder path
    ) {

        if(path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        for(Character c : dic.get(digits.charAt(index))) {
            StringBuilder newPath = new StringBuilder(path).append(c);
            dfs(result, dic, digits, index + 1, newPath);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // 예외 처리
        if(digits.length() == 0) {
            return result;
        }
        
        // 번호에 해당하는 문자 목록 구성
        Map<Character, List<Character>> dic = Map.ofEntries(
            Map.entry('0', List.of()), 
            Map.entry('1', List.of()), 
            Map.entry('2', List.of('a', 'b', 'c')), 
            Map.entry('3', List.of('d', 'e', 'f')), 
            Map.entry('4', List.of('g', 'h', 'i')), 
            Map.entry('5', List.of('j', 'k', 'l')), 
            Map.entry('6', List.of('m', 'n', 'o')), 
            Map.entry('7', List.of('p', 'q', 'r', 's')), 
            Map.entry('8', List.of('t', 'u', 'v')), 
            Map.entry('9', List.of('w', 'x', 'y', 'z'))
        );
        
        // 재귀 호출
        dfs(result, dic, digits, 0, new StringBuilder());
        return result;
    }
}
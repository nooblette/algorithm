class Solution {
    public String removeDuplicateLetters(String s) {
        // 기존 문자열 s에 등장하는 문자를 key, 등장하는 횟수를 value로 갖는다.
        Map<Character, Integer> counter = new HashMap<>();
        
        // 기존 문자열 s에 등장하는 문자 key가 stack에 존재하는지 여부를 저장한다.
        Map<Character, Boolean> seen = new HashMap<>();
        
        // 중복을 제거하고 사전순서대로 문자를 쌓는다.
        Deque<Character> stack = new ArrayDeque();
        
        // 문자별 개수 계산
        for(char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }
        
        // 문자 순회하며 사전 순서로 스택에 저장
        for(char c : s.toCharArray()) {
            // 현재 문자의 counter 1 감소
            counter.put(c, counter.get(c) - 1);
            
            // 이미 처리한 문자는 넘어간다. (중복 제거)
            if(seen.get(c) != null && seen.get(c) == true) {
                continue;
            }
            
            // 문자를 추가해야하는데 이미 스택에 저장된 문자가 현재 문자보다 사전상 뒤에 와야한다면, 또한 이후 s에 다시 등장하다면
            while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                // 기존에 스택에 있는 문자를 제거한다.
                seen.put(stack.peek(), false);
                stack.pop();
            }
            
            // 현재 문자를 스택에 추가하고 방문했다고 남긴다.
            stack.push(c);
            seen.put(c, true);
        }
        
        // 스택에 쌓여있는 문자를 문자열로 변환하여 반환한다.
        // 스택에는 사전 순서대로 쌓여있으므로(먼저 오는 문자가 가장 아래에 있음), 마지막 문자부터 꺼내어 문자열로 변환한다.
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}
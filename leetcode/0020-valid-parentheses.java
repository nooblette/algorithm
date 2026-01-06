class Solution {
    public boolean isValid(String s) {
        // 유효성 검증을 위한 스택
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> parentheses = Map.of('(', ')', '{', '}', '[', ']');
        for(char c : s.toCharArray()) {
            // 여는 괄호라면 스택에 추가
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                // 스택이 비어있지 않으면서 가장 위 문자와 쌍이 맞는다면 제거
                if(!stack.isEmpty() && c == parentheses.get(stack.peekLast())) {
                    stack.removeLast();
                } else {
                    // 스택이 도중에 비거나 유효하지 않은 쌍 존재
                    return false;
                }
            }
        }

        // 스택이 비어있다면 모든 쌍이 유효함
        return stack.isEmpty();
    }
}

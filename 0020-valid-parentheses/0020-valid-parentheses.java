class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> parentheses = Map.of('(', ')', '[', ']', '{', '}');
        
        for(char c : s.toCharArray()) {
            // 여는 괄호라면 닫힌 괄호를 스택에 추가
            if(parentheses.containsKey(c)) {
                stack.push(parentheses.get(c));
            } else {
                // 중간에 스택이 비거나 가장 위에 값과 다르다면 짝이 맞지 않음
                if(stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // 스택이 비어있다면 짝지어진 괄호
        return stack.isEmpty();
    }
}
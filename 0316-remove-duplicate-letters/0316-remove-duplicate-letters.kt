class Solution {
    fun removeDuplicateLetters(s: String): String {
        // 기존 문자열 s에 등장하는 문자를 key, 등장하는 횟수를 value로 갖는다.
        val counter: MutableMap<Char, Int> = HashMap()

        // 기존 문자열 s에 등장하는 문자 key가 stack에 존재하는지 여부를 저장한다.
        val seen: MutableMap<Char, Boolean> = HashMap()

        // 중복을 제거하고 사전순서대로 문자를 쌓는다.
        val stack: Deque<Char> = LinkedList()
        
        // 문자별 개수 계산
        for(c in s) {
            counter[c] = counter.getOrDefault(c, 0) + 1
        }
        
        // 문자 순회하며 사전 순서로 스택에 저장
        for(c in s) {
            // 현재 문자의 counter 1 감소
            // 현재 처리하는 문자는 counter에서 -1
            counter[c] = counter[c]!! - 1   
            
            // 이미 처리한 문자는 건너뛴다.
            if(seen[c] == true) {
                continue
            }
            
            // 문자를 추가해야하는데 이미 스택에 저장된 문자가 현재 문자보다 사전상 뒤에 와야한다면, 또한 이후 s에 다시 등장하다면
            while(!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0) {
                // 기존에 스택에 있는 문자를 제거한다.
                seen[stack.pop()] = false
            }
            
            // 현재 문자를 스택에 삽입
            stack.push(c)
            
            // 현재 문자를 처리한 것으로 선언
            seen[c] = true
        }
        
        // 스택에 쌓여있는 문자를 문자열로 변환하여 반환한다.
        // 스택에는 사전 순서대로 쌓여있으므로(먼저 오는 문자가 가장 아래에 있음), 마지막 문자부터 꺼내어 문자열로 변환한다.(큐 순서대로 꺼내어 변환)
        val sb = StringBuilder()
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast())
        }
        return sb.toString()
    }
}
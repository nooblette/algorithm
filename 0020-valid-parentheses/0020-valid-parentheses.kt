import java.util.ArrayDeque
import java.util.Deque

class Solution {
    fun isValid(s: String): Boolean {
        // 유효성 검증을 위한 스택 선언
        val stack: Deque<Char> = ArrayDeque<Char>()
        
        // 유효성 검증을 위한 해시 테이블, 값 삽입/삭제 불가
        val table: Map<Char, Char> = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        
        // 문자열을 문자 단위로 반복
        for(i in s.indices) {
            // 닫힘 괄호가 아닌 경우 스택에 푸시
            if(!table.containsKey(s[i])) {
                stack.push(s[i])
            }
            
            // 중간에 스택이 비거나, 스택에 열림 괄호가 아닌 문자가 있는 경우 실패
            else if(stack.isEmpty() || table[s[i]] !== stack.pop()) {
                return false
            }
        }
        
        // 스택이 전부 비어있으면 짝이 제대로 맞은 것
        return stack.size == 0
    }
}
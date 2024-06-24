import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> check = new Stack<>();
        boolean answer = true;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(check.isEmpty()){
                if(c == ')') {
                    answer = false;
                    break;
                }
                
                check.push(s.charAt(i));
                continue;
            }
            
            
            if((check.peek() == '(' && c == '(')
               || (check.peek() == '(' && c == '(')) {
                check.push(s.charAt(i));
                continue;
            }
            
            if((c == ')' && check.peek() == '(')
               || (c == '(' && check.peek() == ')')) {
                check.pop();
                continue;
            }
            
            answer = false;
            break;
        }
        
        if(!check.isEmpty()) {
            return false;
        }

        return answer;
    }
}
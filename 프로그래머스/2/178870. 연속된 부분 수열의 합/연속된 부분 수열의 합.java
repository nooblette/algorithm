class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int[] answer = {start, end};
        int sum = sequence[start];
        int range = sequence.length + 1;
        
        while(true){
            if(start == sequence.length || end == sequence.length){
                break;
            }
            
            if(sum == k) {
                if(range > end - start + 1){
                    answer[0] = start;
                    answer[1] = end;
                    range = end - start + 1;
                }
                
                sum -= sequence[start];
                start += 1;
            } else if(sum < k) {
                end += 1;
                if(end == sequence.length){
                    break;
                }
                sum += sequence[end];
            } else {
                sum -= sequence[start];
                start += 1;
            }
        }
        
        return answer;
    }
}
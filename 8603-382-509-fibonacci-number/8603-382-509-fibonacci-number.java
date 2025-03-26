class Solution {
    public int fib(int n) {
        int x = 0, y = 1;
        for(int i = 0; i < n; i++) {
            // 작은 문제들로 큰 문제를 구한다.
            int z = x + y;
            
            // 작은 문제들 갱신
            x = y;
            y = z;
        }
        
        return x;
    }
}
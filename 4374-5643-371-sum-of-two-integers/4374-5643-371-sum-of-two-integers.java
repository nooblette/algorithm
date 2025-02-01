class Solution {
    public int getSum(int a, int b) {
        // b가 0이 될때까지 반복
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        
        return a;
    }
}
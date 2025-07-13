class Solution {
    public int getSum(int a, int b) {
         while (b != 0) {
            int carry = (a & b) << 1;  // carry 계산
            a = a ^ b; // carry 없는 합
            b = carry;
        }

        return a;
    }
}

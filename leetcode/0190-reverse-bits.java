class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++) {
            // result 좌측 shift
            result <<= 1;

            // 주어진 정수 n의 가장 우측 비트 추출하여 result에 할당
            result |= (n & 1);

            // 정수 n 우측 shift
            n >>= 1;
        }

        return result;
    }
}

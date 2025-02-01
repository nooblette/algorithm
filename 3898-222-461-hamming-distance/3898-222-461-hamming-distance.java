class Solution {
    public int hammingDistance(int x, int y) {
        // 두 정수의 비트 중 다른 숫자를 세기 위해 XOR 연산을 수행한다.
        int xor = x ^ y;
        
        // 정수형을 이진수로 표현했을 때 값이 1인 자리의 개수를 구한다.
        return Integer.bitCount(xor);
    }
}
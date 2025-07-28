class Solution {
    public int reverseBits(int n) {
        // 주어진 정수를 비트 문자열로 변환
        // 앞자리가 0이 오는 경우를 보존하기 위해 String.format()으로 32자리 패딩한다.
        String binaryN = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        // 비트 문자열을 뒤집는다.
        StringBuilder sb = new StringBuilder(binaryN);
        String reversed = sb.reverse().toString();
        
        return Integer.parseInt(reversed, 2);
    }
}

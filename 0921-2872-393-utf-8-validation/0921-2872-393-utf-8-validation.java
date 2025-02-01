class Solution {
    private boolean check(int[] data, int start, int size) {
        // size만큼 이동하면서 각 바이트가 10으로 시작하는지 검증
        for(int i = start + 1; i < start + size + 1; i++) {
            if(i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }

        return true;
    }
    
    public boolean validUtf8(int[] data) {
        // 문자 전체 길이만큼 순회
        int start = 0;
        while(start < data.length) {
            // 문자의 시작 바이트
            int first = data[start];

            // 11110으로 시작하는 경우 나머지가 3바이트이고 10으로 시작해야한다.
            if(first >> 3 == 0b11110 && check(data, start, 3)) {
                // 검증한 바이트 묶음 이후 바이트를 검증하기 위해 이번 루프에서 검증한 길이만큼 증가한다.
                start += 4;
            } else if(first >> 4 == 0b1110 && check(data, start, 2)) {
                // 1110으로 시작하는 경우 나머지가 2바이트이고 10으로 시작해야한다.
                start += 3;
            } else if(first >> 5 == 0b110 && check(data, start, 1)) {
                // 110으로 시작하는 경우 나머지가 1바이트이고 10으로 시작해야한다.
                start += 2;
            } else if(first >> 7 == 0) {
                // 1바이트 문자인 경우
                start++;
            } else {
                return false;
            }
        }
        
        return true;  
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 각 단계별로 최적해를 구하기 위해 주어진 배열 정렬
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0; // 어린이를 가리키는 인덱스
        int j = 0; // 쿠키를 가리키는 인덱스
        
        while(i < g.length && j < s.length) {
            // 쿠키로 만족할 수 있다면 다음 어린이가 쿠키를 받을 수 있는지 검증한다.
            if(g[i] <= s[j]) {
                i++;
            }
            
            j++;
        }
        
        // 쿠키를 받은(조건을 만족했던) 어린이의 수 반환
        return i;
    }
}
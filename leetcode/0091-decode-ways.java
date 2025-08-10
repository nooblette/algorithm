class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        int end = s.length();

        return topDown(s, 0, end, 1) + topDown(s, 0, end, 2);
    }

    private int topDown(String s, int index, int end, int size) {
        // 메모이제이션 키
        String key = index + ":" + size;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // 범위 초과
        if(index + size > end) {
            memo.put(key, 0);    
            return 0;
        }

        String str = s.substring(index, index + size);

        // 디코딩 불가능한 케이스
        if(str.startsWith("0") || (size == 2 && Integer.parseInt(str) > 26)) {
            memo.put(key, 0);
            return 0;
        }

        // 디코딩 성공
        if(index + size == end) {
            memo.put(key, 1);
            return 1;
        }

        int result = topDown(s, index + size, end, 1) + topDown(s, index + size, end, 2);
        memo.put(key, result);
        return result;
    }
}

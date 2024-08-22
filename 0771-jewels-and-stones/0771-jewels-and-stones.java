class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> freqs = new HashMap<>();
        
        for(char s : stones.toCharArray()) {
            // 만약 이미 계산한 돌이면 기존값 + 1
            if(freqs.containsKey(s)) {
                freqs.put(s, freqs.get(s) + 1);
            }

            // 처음 보는 돌이면 hash에 추가
            else {
                freqs.put(s, 1);
            }
        }
        
        int count = 0;
        for(char j : jewels.toCharArray()) {
            // 보석과 일치하는 돌의 개수를 합산
            if(freqs.containsKey(j)) {
                count += freqs.get(j);
            }
        }

        return count;
    }
}
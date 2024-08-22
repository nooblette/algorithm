class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var freqs: HashSet<Char> = HashSet()
        
        // 보석 jewels 종류 저장
        for(j in jewels.toCharArray()) {
            freqs.add(j)
        }
        
        // stones이 jewels인 경우
        var count = 0
        for(s in stones.toCharArray()) {
            if(freqs.contains(s)) {
                count++
            }
        }
        
        return count
    }
}
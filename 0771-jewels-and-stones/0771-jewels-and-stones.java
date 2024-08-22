class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> freqs = new HashSet<>();
        
        // 보석 추출 및 저장, 종류별로 하나만 저장된다.
        for(char j : jewels.toCharArray()) {
            freqs.add(j);
        }
        
        int count = 0;
        // stones를 추출해서 저장했던 보석과 일치하는지 비교한다. 일치한다면 count를 증가한다.
        for(char c : stones.toCharArray()) {
            if(freqs.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
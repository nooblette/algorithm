class Solution {
    public int hammingWeight(int n) {
        return Integer.toBinaryString(n)
            .replace("0", "")
            .length();
    }
}

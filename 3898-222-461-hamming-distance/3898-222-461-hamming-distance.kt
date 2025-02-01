class Solution {
    fun hammingDistance(x: Int, y: Int): Int = Integer.bitCount(x xor y)
}
class Solution {
    fun isAnagram(s: String, t: String): Boolean = String(s.toCharArray().apply { sort() }) == String(t.toCharArray().apply { sort() })
}
class Solution {
    fun sort(s: String): String {
        val c = s.toCharArray()
        Arrays.sort(c)
        
        return String(c)
    }
    
    fun isAnagram(s: String, t: String): Boolean = sort(s) == sort(t)
}
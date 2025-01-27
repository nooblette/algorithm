class Solution {
    public String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }
}
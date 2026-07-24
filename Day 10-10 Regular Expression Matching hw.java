class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0, new HashMap<>());
    }
    
    private boolean match(String s, String p, int i, int j, Map<String, Boolean> memo) {
        if (j == p.length()) return i == s.length();
        
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);
        
        boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        boolean result;
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = match(s, p, i, j + 2, memo) || (firstMatch && match(s, p, i + 1, j, memo));
        } else {
            result = firstMatch && match(s, p, i + 1, j + 1, memo);
        }
        
        memo.put(key, result);
        return result;
    }
}

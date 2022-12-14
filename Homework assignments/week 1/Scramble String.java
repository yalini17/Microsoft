class Solution {
    static Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1 == s2) {
            return true;
        }
        return solve(s1, s2);
    }
    
    public static boolean solve(String s1,String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        
        int n = s1.length();
        String key = s1+"_"+s2;
        if (n <= 1) {
            map.put(key, false);
            return false;
        }
        if (map.containsKey(key)) {
            return map.get(key);
        }
        boolean isScrambled = false;
        for (int i=1; i<n; i++) {
            
            if(solve(s1.substring(0,i), s2.substring(0,i)) && solve(s1.substring(i), s2.substring(i))) {
                isScrambled = true;
                break;
            }
            if (solve(s1.substring(0,i), s2.substring(n-i)) && solve(s1.substring(i), s2.substring(0,n-i))) {
                isScrambled = true;
                break;
            }
        }
        map.put(key, isScrambled);
        return isScrambled;
    } 
}

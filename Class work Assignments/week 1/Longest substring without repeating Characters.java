class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        int i=0,j=0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int count=0;
        int maxCount=0;
        while(i<l){
            while(hm.get(s.charAt(i)) != null && j<=i){
                hm.remove(s.charAt(j));
                j++;
            }
            hm.put(s.charAt(i),i);
            count=i-j+1;
            i++;
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
}
}

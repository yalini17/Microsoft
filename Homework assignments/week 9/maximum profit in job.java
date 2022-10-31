class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] combine = new int [startTime.length][3];
        for (int i=0; i<startTime.length; i++) {
            combine[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(combine, (a,b)->a[1]-b[1]);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        
        for (int[] curr: combine) {
            Integer prev = map.floorKey(curr[0]);
            int prevSum = prev==null?0:map.get(prev);
            ans = Math.max(ans, prevSum+curr[2]);
            map.put(curr[1], ans);
        }              
        return ans;
    }
}
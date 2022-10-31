class Solution {
 public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int k=n-1; k>=0; k--){
            int op1 = costs[0] + dp[k+1];
            int i;
            for(i=k; i<n && days[i] < days[k] + 7; i++);
            int op2 = costs[1] + dp[i];

            for(i=k; i<n && days[i] < days[k] + 30; i++);
            int op3 = costs[2] + dp[i];

            dp[k] = Math.min(op1, Math.min(op2, op3));
        }
        return dp[0];
    }
}
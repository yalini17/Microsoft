class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length()-1;
        int n2=word2.length()-1;
        int dp[][]=new int[n1+2][n2+2];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                dp[i][j]=-1;
            }
        }
        return dp[n1+1][n2+1]=1+helper(word1,word2,n1,n2,dp);
    }
    public int helper(String word1,String word2,int index1,int index2,int dp[][]){
        if(index1==-1){
            return index2;
        }
        if(index2==-1){
            return index1;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)){
            return dp[index1][index2]=helper(word1,word2,index1-1,index2-1,dp);
        }
        else{
            int replace=1+helper(word1,word2,index1-1,index2-1,dp);
            int insert=1+helper(word1,word2,index1,index2-1,dp);
            int delete=1+helper(word1,word2,index1-1,index2,dp);
            dp[index1][index2]=Math.min(delete,Math.min(insert,replace));
        }
return dp[index1][index2];
        
    }
}

// Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.


//         Example 1:

//         Input:
//         n = 4 , m = 3
//         S[] = {1,2,3}
//         Output: 4
//         Explanation: Four Possible ways are:
//         {1,1,1,1},{1,1,2},{2,2},{1,3}.
//         Example 2:

//         Input:
//         n = 10 , m = 4
//         S[] ={2,5,3,6}
//         Output: 5
//         Explanation: Five Possible ways are:
//         {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
//         and {5,5}.



class Solution {
    public long count(int[] coins, int amount) {
        return solve(coins,amount);
    }
    
    public long solve(int[] coins, int amount) {
        int n=coins.length;
        long t[][]=new long [n+1][amount+1];
        
        for(int i=0;i<n+1;i++) t[i][0]=1;
        for(int j=1;j<amount+1;j++) t[0][j]=0;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j)
                     t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
                 else
                     t[i][j]=t[i-1][j];
            }
        }
        return t[n][amount];
    }
}

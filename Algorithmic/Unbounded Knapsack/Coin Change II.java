// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

//       Example 1:
//       Input: coins = [1,2,5], amount = 11
//       Output: 3
//       Explanation: 11 = 5 + 5 + 1

//       Example 2:
//       Input: coins = [2], amount = 3
//       Output: -1
//       Example 3:



class Solution {
    public int coinChange(int[] coins, int amount) {
        return solve(coins,amount);
    }
    
    public int solve(int[] coins, int amount) {
        int n=coins.length;
        int t[][]=new int [n+1][amount+1];
        
        for(int i=1;i<n+1;i++) t[i][0]=0;
        for(int j=0;j<amount+1;j++) t[0][j]=-1;
        
      //special case, initialize second row
        for(int j=1;j<amount+1;j++){
            if(j%coins[0]==0)
                t[1][j]=j/coins[0];
            else
                t[1][j]=-1;
        }
        
        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j)
                     t[i][j]=Math.min( 1+ t[i][j-coins[i-1]],t[i-1][j]);
                 else
                     t[i][j]=t[i-1][j];
            }
        }
    return t[coins.length][amount] == 2147483646 ? -1 : t[coins.length][amount];
    }
}

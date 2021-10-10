// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

//       Input: nums = [1,1,1,1,1], target = 3
//       Output: 5
//       Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//       -1 + 1 + 1 + 1 + 1 = 3
//       +1 - 1 + 1 + 1 + 1 = 3
//       +1 + 1 - 1 + 1 + 1 = 3
//       +1 + 1 + 1 - 1 + 1 = 3
//       +1 + 1 + 1 + 1 - 1 = 3


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int arrsum = 0;
        for(int i = 0; i < nums.length; i++) arrsum += nums[i];
    
        if(target > arrsum || ((arrsum - target) % 2 == 1)) return 0;
        
        int sum = ((arrsum - target) / 2);
        
        return countofsubsetsum(nums,sum);
    }
  
     public int countofsubsetsum(int[] arr, int sum){
         int n=arr.length;
         int t[][]=new int[n+1][sum+1];
         
         for(int i=0;i<n+1;i++) t[i][0]=1;
         for(int j=1;j<sum+1;j++) t[0][j]=0;
         
         for(int i=1;i<n+1;i++){
             for(int j=0;j<sum+1;j++){
                 if(arr[i-1]<=j){
                      t[i][j]=t[i-1][j]+t[i-1][j-arr[i-1]];
                 }
                 else{
                     t[i][j]=t[i-1][j];
                 }
             }
         }
         return t[n][sum];
     }
}

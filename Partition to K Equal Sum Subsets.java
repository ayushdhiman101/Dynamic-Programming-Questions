// 136/142 TEST CASE PASSED

// Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
//     Example 1:

//     Input: nums = [4,3,2,3,5,2,1], k = 4
//     Output: true
//     Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//     Example 2:

//     Input: nums = [1,2,3,4], k = 3
//     Output: false

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int arrsum=0;
        for(int i=0;i<nums.length;i++) arrsum+=nums[i];
        
        if(k>arrsum) return false;
        if(k==1) return true;
        if(k>nums.length) return false;
        if(arrsum%k != 0) return false;
        
        
        int sum=arrsum/k;
        
        return subsetsumproblem(nums,sum,k);
        
    }
     public boolean subsetsumproblem(int[] arr, int sum,int k){
         int n=arr.length;
         boolean t[][]=new boolean[n+1][sum+1];
         
         for(int i=0;i<n+1;i++) t[i][0]=true;
         for(int j=1;j<sum+1;j++) t[0][j]=false;
         
         for(int i=1;i<n+1;i++){
             for(int j=0;j<sum+1;j++){
                 if(arr[i-1]<=j){
                      t[i][j]=t[i-1][j] || t[i-1][j-arr[i-1]];
                 }
                 else{
                     t[i][j]=t[i-1][j];
                 }
             }
         }
         return t[n][sum];
     }
}

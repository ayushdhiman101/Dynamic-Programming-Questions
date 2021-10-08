//Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

/*
Example 1:

      Input:
      N = 6
      arr[] = {3, 34, 4, 12, 5, 2}
      sum = 9
      Output: 1 
      Explanation: Here there exists a subset with
      sum = 9, 4+3+2 = 9.
      Example 2:

      Input:
      N = 6
      arr[] = {3, 34, 4, 12, 5, 2}
      sum = 30
      Output: 0 
      Explanation: There is no subset with sum 30.
*/      
      
      
      class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        boolean t[][]=new boolean[n+1][sum+1];
         for (int i = 0; i < n+1; i++){
         for (int j = 0; j < sum+1; j++){
            if(i==0) t[i][j] = false;
            
            if(j==0) t[i][j] = true;
         }}
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j] ;
                }
                else{
                    t[i][j]= t[i-1][j];
                }
                
            }
        }
        
        
        return t[n][sum];
        
    }
}

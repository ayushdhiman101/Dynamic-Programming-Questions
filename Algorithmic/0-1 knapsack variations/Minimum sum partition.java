// Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

// Example 1:
//   Input: N = 4, arr[] = {1, 6, 11, 5} 
//   Output: 1
//   Explanation: 
//   Subset1 = {1, 5, 6}, sum of Subset1 = 12 
//   Subset2 = {11}, sum of Subset2 = 11   
// Example 2:
//   Input: N = 2, arr[] = {1, 4}
//   Output: 3
//   Explanation: 
//   Subset1 = {1}, sum of Subset1 = 1
//   Subset2 = {4}, sum of Subset2 = 4


class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int i=0;i<arr.length;i++) sum+=arr[i];
	    
	    ArrayList<Integer> v= new ArrayList<Integer> ();
	    v=subsetSum(arr,sum);

	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<v.size();i++) {
	        int x=sum-2*(v.get(i));
	        min=Math.min(x,min);
	    }
	    return min;
	   
	} 
	
		public ArrayList<Integer> subsetSum(int [] arr,int sum){
	    
	    int n=arr.length;
	    boolean t[][]=new boolean [n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++) t[i][0]=true;
	    for(int j=1;j<sum+1;j++) t[0][j]=false;
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
	            
	            if(arr[i-1]<=j){
	                t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
	            }
	            else{
	                t[i][j]=t[i-1][j];
	            }
        	}
        }
        ArrayList<Integer> v= new ArrayList<Integer> ();
        for(int i=0;i<(sum/2)+1;i++){
            if(t[n][i]) v.add(i);
        }
	    return v;
	}
}

// Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

//         Example 1:

//         Input:
//         N = 8
//         Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
//         Output:
//         22
//         Explanation:
//         The maximum obtainable value is 22 by
//         cutting in two pieces of lengths 2 and 
//         6, i.e., 5+17=22.
//         Example 2:

//         Input:
//         N=8
//         Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
//         Output: 24
//         Explanation: 
//         The maximum obtainable value is 
//         24 by cutting the rod into 8 pieces 
//         of length 1, i.e, 8*3=24. 


class Solution{
    public int cutRod(int price[], int n) {
        return solve(price,n);
    }
    
    public int solve(int price[], int w){
        int n= price.length;
      
        int length[]=new int[n];
        for(int i=1;i<n+1;i++) length[i-1]=i;
           
        int t[][] = new int [n+1][w+1];
        
        for(int i=0;i<n+1;i++) t[i][0]=0;
        for(int j=0;j<w+1;j++) t[0][j]=0;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(length[i-1]<=j)
                    t[i][j]=Math.max((price[i-1]+t[i][j-length[i-1]]),t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][n];
    }
}

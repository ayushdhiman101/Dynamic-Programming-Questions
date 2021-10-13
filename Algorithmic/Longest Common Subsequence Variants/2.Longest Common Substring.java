// Given two strings. The task is to find the length of the longest common substring.


//       Example 1:
//       Input: S1 = "ABCDGH", S2 = "ACDGHR"
//       Output: 4
//       Explanation: The longest common substring
//       is "CDGH" which has length 4.
  
//       Example 2:
//       Input: S1 = "ABC", S2 "ACB"
//       Output: 1
//       Explanation: The longest common substrings
//       are "A", "B", "C" all having length 1.

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        return solve(S1,S2,n,m);
    }
     public int solve(String x, String y, int n, int m) {
                int t[][]=new int [n+1][m+1];

                for(int i=0;i<n+1;i++) t[i][0]=0;
                for(int j=1;j<m+1;j++) t[0][j]=0;
                    
                for(int i=1;i<n+1;i++){
                     for(int j=1;j<m+1;j++){
                            if(x.charAt(i-1)==y.charAt(j-1))
                                t[i][j]= (1 + t[i-1][j-1]);
                            else
                                t[i][j]= 0;
                    }
                }
                 int max=-1;
                 for(int i=0;i<n+1;i++){
                     for(int j=0;j<m+1;j++){
                         if(t[i][j]>max) max=t[i][j];
                     }
                 }
       return max;
    }
}

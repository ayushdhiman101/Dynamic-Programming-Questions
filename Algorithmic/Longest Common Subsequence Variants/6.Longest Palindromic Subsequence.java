// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".
  
// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".



class Solution {
    public int longestPalindromeSubseq(String str) {
        int m=str.length();
        
        StringBuilder a = new StringBuilder(str);
        StringBuilder temp=new StringBuilder(a);
        StringBuilder b = new StringBuilder(temp.reverse());
        
        return LCS(a.toString(),b.toString(),m,m);
    }
    public static int LCS(String X, String Y, int m, int n){
         int t[][]=new int [m+1][n+1];
     
         for(int i=0;i<m+1;i++) t[i][0]=0;
         for(int j=0;j<n+1;j++) t[0][j]=0;
         
         for(int i=1;i<m+1;i++){
             for(int j=1;j<n+1;j++){
                if(X.charAt(i-1)==Y.charAt(j-1))
                     t[i][j]= 1+t[i-1][j-1];
                else
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
         }
    return t[m][n];
    }
}

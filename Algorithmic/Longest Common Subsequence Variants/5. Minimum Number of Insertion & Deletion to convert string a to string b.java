// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

// In one step, you can delete exactly one character in either string.

 
// Example 1:
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
  
// Example 2:
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        
        int x= LCS(word1,word2,m,n);
        
        int deletion=m-x;
        int insertion=n-x;
        return deletion+insertion;
        
    }
    public int LCS(String a, String b,int m,int n){
            int t[][]=new int [m+1][n+1];
            
            for(int i=0;i<m+1;i++) t[i][0]=0;
            for(int j=0;j<n+1;j++) t[0][j]=0;
            
            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){
                    if(a.charAt(i-1)==b.charAt(j-1))
                        t[i][j]=1+ t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
                }
            }
            return t[m][n];
    }
}

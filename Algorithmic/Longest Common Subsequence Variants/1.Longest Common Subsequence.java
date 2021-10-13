// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.



//  TOP DOWN APPROACH (RECURSION WITH Memoization)

class Solution {
    static int t[][]=new int [1000][1000];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                t[i][j]=-1;
            }
        }
        return solve(text1,text2,n,m);
    }
  
    public int solve(String x, String y, int n, int m) {
                if(n==0 || m==0) return 0;
                if(t[n][m]!=-1) return t[n][m];
                if(x.charAt(n-1)==y.charAt(m-1))
                    return t[n][m]= (1 + solve(x,y,n-1,m-1));
                else
                    return t[n][m]= Math.max(solve(x,y,n,m-1,t),solve(x,y,n-1,m));
            }
        }

//  BOTTOM UP APPROACH (TABLE)

class Solution {
    static int t[][]=new int [1000][1000];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m=text2.length();
        return solve(text1,text2,n,m);
    }
  
    public int solve(String x, String y, int n, int m) {
                for(int i=0;i<n+1;i++) t[i][0]=0;
                for(int j=1;j<m+1;j++) t[0][j]=0;
                    
                for(int i=1;i<n+1;i++){
                     for(int j=1;j<m+1;j++){
                            if(x.charAt(i-1)==y.charAt(j-1))
                                t[i][j]= (1 + t[i-1][j-1]);
                            else
                                t[i][j]= Math.max(t[i][j-1],t[i-1][j]);
                    }
                }
        return t[n][m];
    }
}
        


        

// Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
// Note: X and Y can have both uppercase and lowercase letters.

    // Example 1
    // Input:
    // X = abcd, Y = xycd
    // Output: 6
    // Explanation: Shortest Common Supersequence
    // would be abxycd which is of length 6 and
    // has both the strings as its subsequences.

    // Example 2
    // Input:
    // X = efgh, Y = jghi
    // Output: 6
    // Explanation: Shortest Common Supersequence
    // would be ejfghi which is of length 6 and
    // has both the strings as its subsequences.

class Solution
{
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
       int common= LCS(X,Y,m,n);
       return (m+n)-common;
    }
    public static int LCS(String X, String Y, int m, int n){
         int t[][]=new int [m+1][n+1];
     
         for(int i=0;i<m+1;i++) t[i][0]=0;
         for(int j=0;i<n+1;j++) t[0][j]=0;
         
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

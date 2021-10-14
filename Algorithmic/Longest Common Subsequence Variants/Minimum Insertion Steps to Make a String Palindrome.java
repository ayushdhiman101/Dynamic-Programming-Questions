//SAME AS PREVIOUS CODE 7.

// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

 
// Example 1:

// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we don't need any insertions.
// Example 2:

// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".
// Example 3:

// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
// Example 4:

// Input: s = "g"
// Output: 0
// Example 5:

// Input: s = "no"
// Output: 1


class Solution {
    public int minInsertions(String s) {
        int m=s.length();
        int n=s.length();
        StringBuilder a= new StringBuilder(s);
        StringBuilder temp= new StringBuilder(a);
        StringBuilder b= new StringBuilder(temp.reverse());
        
        int x=LCS(a.toString(),b.toString(),m,n);
        
        return m-x;
    }
    int LCS(String a, String b, int m, int n){
        int t[][]=new int [m+1][n+1];
        
        for(int i=0;i<m+1;i++) t[i][0]=0;
        for(int j=1;j<n+1;j++) t[0][j]=0;
        
         for(int i=1;i<m+1;i++){
              for(int j=1;j<n+1;j++){
                    if(a.charAt(i-1)==b.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else 
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
              }
         }
        return t[m][n];
    }
} 

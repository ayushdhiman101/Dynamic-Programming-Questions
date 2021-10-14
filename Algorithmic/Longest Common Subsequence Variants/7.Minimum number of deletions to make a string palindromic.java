// Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. Find the minimum numbers of characters we need to remove.
// Note: The order of characters should be maintained.

// Example 1:
// Input: n = 7, str = "aebcbda"
// Output: 2
// Explanation: We'll remove 'e' and
// 'd' and the string become "abcba".

// Example 2:
// Input: n = 3, str = "aba"
// Output: 0
// Explanation: We don't remove any
// character.

class Solution 
{ 
    int minDeletions(String str, int n)
    {
        int m=n;
        StringBuilder a= new StringBuilder(str);
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

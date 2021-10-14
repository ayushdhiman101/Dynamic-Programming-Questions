// Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.

// Example 1:
// Input:
// str = "axxxy"
// Output: 2
// Explanation:
// The given array with indexes looks like
// a x x x y 
// 0 1 2 3 4

// The longest subsequence is "xx". 
// It appears twice as explained below.

// subsequence A
// x x
// 0 1  <-- index of subsequence A
// ------
// 1 2  <-- index of str 


// subsequence B
// x x
// 0 1  <-- index of subsequence B
// ------
// 2 3  <-- index of str 

// We are able to use character 'x' 
// (at index 2 in str) in both subsequences
// as it appears on index 1 in subsequence A 
// and index 0 in subsequence B.
  
// Example 2:
// Input:
// str = "aab"
// Output: 1
// Explanation: 
// The longest reapting subsequenece is "a".
  
  
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
	int m=str.length();
	return LCS(str,str,m,m);
    }
    public int LCS(String a, String b, int m, int n){
        int t[][]=new int [m+1][n+1];
        
        for(int i=0;i<m+1;i++) t[i][0]=0;
        for(int j=1;j<n+1;j++) t[0][j]=0;
        
         for(int i=1;i<m+1;i++){
              for(int j=1;j<n+1;j++){
                    if((a.charAt(i-1)==b.charAt(j-1)) && i!=j) // extra condition i!=j added 
                        t[i][j]=1+t[i-1][j-1];
                    else 
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
              }
         }
        return t[m][n];
    }
} 

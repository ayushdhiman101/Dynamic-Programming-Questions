// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

// Example 1:
// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.
  
// Example 2:
// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"
  
  
class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        
        return LCS_plus_modifications(str1,str2,m,n);
    }
    
     public String LCS_plus_modifications(String a, String b, int m,int n){
         int t[][]=new int[m+1][n+1];
         
        for(int i=0;i<m+1;i++) t[i][0]=0;
        for(int j=1;j<n+1;j++) t[0][j]=0;
                    
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    t[i][j]= (1 + t[i-1][j-1]);
                else
                    t[i][j]= Math.max(t[i][j-1],t[i-1][j]);
            }
        }   
         
        StringBuilder ans=new StringBuilder();
        int i=m;
        int j=n;
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                 ans.append(a.charAt(i-1));
                 i--;
                 j--;
             }
             else{
                 if(t[i-1][j]>t[i][j-1]){
                     ans.append(a.charAt(i-1));
                     i--;
                 }
                 else {
                     ans.append(b.charAt(j-1));
                     j--;
                 }
             }
         }
         
         while(i>0){
            ans.append(a.charAt(i-1));
            i--;
         }
         while(j>0){
            ans.append(b.charAt(j-1));
            j--;
         }
         ans.reverse();
         return ans.toString();
     }
}

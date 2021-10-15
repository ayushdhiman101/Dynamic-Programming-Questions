// Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


// Example 1:
// Input: str = "ababbbabbababa"
// Output: 3
// Explaination: After 3 partitioning substrings 
// are "a", "babbbab", "b", "ababa".
  
// Example 2:
// Input: str = "aaabba"
// Output: 1
// Explaination: The substrings after 1
// partitioning are "aa" and "abba".

class Solution{
    static int palindromicPartition(String str){
        int i=0;
        int j=str.length()-1;
        return solve(str,i,j);
    }
    
    static int solve(String str, int i ,int j ){
        if(i>=j)
            return 0;
            
        if(ispalindrome(str,i,j))
            return 0;
        
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans= solve(str,i,k) + solve(str,k+1,j) + 1;
            min=Math.min(tempans,min);
        }
    return min;
    }
    static boolean ispalindrome(String str,int i ,int j ){
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
                i++;
                j--;
        }
        return true;
    }
}

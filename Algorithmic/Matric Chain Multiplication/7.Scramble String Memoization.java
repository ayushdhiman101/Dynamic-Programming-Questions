// We can scramble a string s to get a string t using the following algorithm:

// If the length of the string is 1, stop.
// If the length of the string is > 1, do the following:
// Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
// Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
// Apply step 1 recursively on each of the two substrings x and y.
// Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 
// Example 1:
// Input: s1 = "great", s2 = "rgeat"
// Output: true
// Explanation: One possible scenario applied on s1 is:
// "great" --> "gr/eat" // divide at random index.
// "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
// "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
// "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
// "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
// "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
// The algorithm stops now and the result string is "rgeat" which is s2.
// As there is one possible scenario that led s1 to be scrambled to s2, we return true.

// Example 2:
// Input: s1 = "abcde", s2 = "caebd"
// Output: false

// Example 3:
// Input: s1 = "a", s2 = "a"
// Output: true


class Solution {
    static HashMap<String,Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length()==0) return true;
        if(s1.length()!=s2.length()) return false;

        return solve(s1,s2);

    }
    public boolean solve(String a, String b) {
        if(a.equals(b))
            return true;

        String key=a+" "+b;

        if(map.containsKey(key.toString()))
            return map.get(key.toString());

        int n=a.length();
        boolean flag=false;
        for(int i=1;i<=n-1;i++){

            boolean case1 = (solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i),b.substring(i)));
            boolean case2 = (solve(a.substring(0,i),b.substring(n-i)) && solve (a.substring(i),b.substring(0,n-i)));

            if(case1 || case2){
                flag=true;
                break;
            }

        }
        map.put(key,flag);
        return flag;
    }
}

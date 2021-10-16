// Given a boolean expression S of length N with following symbols.
// Symbols
//     'T' ---> true
//     'F' ---> false
// and following operators filled between symbols
// Operators
//     &   ---> boolean AND
//     |   ---> boolean OR
//     ^   ---> boolean XOR
// Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

 

// Example 1:
// Input: N = 7
// S = T|T&F^T
// Output: 4
// Explaination: The expression evaluates 
// to true in 4 ways ((T|T)&(F^T)), 
// (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
  
// Example 2:
// Input: N = 5
// S = T^F|F
// Output: 2
// Explaination: ((T^F)|F) and (T^(F|F)) are the 
// only ways.

class Solution{
    static HashMap<String,Integer> map=new HashMap<>();
    static int countWays(int N, String S){
        int i=0;
        int j=N-1;
        boolean isTrue=true;
        return solve(S,i,j,isTrue);
        
    }
    static int solve(String s, int i, int j,boolean isTrue){
        if(i>j) return 0;
        
        if(i==j){
            if(isTrue==true)
               return (s.charAt(i) == 'T') ? 1 : 0;
            else
                return (s.charAt(i) == 'F') ? 1 : 0;
        }
        
        StringBuilder temp=new StringBuilder();
        temp.append(Integer.toString(i));
        temp.append(" ");
        temp.append(Integer.toString(j));
        temp.append(" ");
        temp.append(String.valueOf(isTrue));
        
        if(map.containsKey(temp.toString()))
            return map.get(temp.toString());
        
        int tempans=0;
        for(int k=i+1;k<=j-1;k=k+2){
            
            int lT=solve(s,i,k-1,true);
            int lF=solve(s,i,k-1,false);
            int rT=solve(s,k+1,j,true);
            int rF=solve(s,k+1,j,false);
            
            if (s.charAt(k) == '&'){
                if (isTrue == true)
                    tempans += (lT*rT);
                else
                    tempans += ((lT*rF)+(lF*rT)+(lF*rF));
            }
            else if (s.charAt(k) == '|'){
                if (isTrue == true)
                    tempans += ((lT*rT)+(lT*rF)+(lF*rT));
                else
                    tempans += (lF*rF);
            }
            else {
                if (isTrue == true)
                    tempans += ((lT*rF)+(lF*rT));
                else
                    tempans += ((lT*rT)+(lF*rF));
            }
        }
      return tempans;  
    }
}

class Result {
  public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        int t[][]=new int [1000][1000];
        ArrayList<Integer> arr=new ArrayList<>();
  //LCS CODE TO GET THE TABLE T
        int m=a.size();
        int n=b.size();
        for(int i=0;i<m+1;i++) t[i][0]=0;
        for(int j=1;j<n+1;j++) t[0][j]=0;
                    
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.get(i-1)==b.get(j-1))
                    t[i][j]= (1 + t[i-1][j-1]);
                else
                    t[i][j]= Math.max(t[i][j-1],t[i-1][j]);
            }
        }
  //EXTRA ADDED CODE TO TRAVESE TABLE T    
        int i=m,j=n;
        while(i>0 && j>0){
            if(a.get(i-1)==b.get(j-1)){
                arr.add(a.get(i-1));
                i--;j--;
            }
            else{
                if(t[i][j-1]>t[i-1][j]) j--;
                else i--;  
            }
        }
        Collections.reverse(arr);
        return arr;
    }
}
    

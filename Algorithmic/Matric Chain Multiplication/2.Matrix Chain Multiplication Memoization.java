class Solution{
     
    static int t[][]=new int [500][500];
    static int matrixMultiplication(int N, int arr[])
    {
        int i=1;
        int j=N-1;
        
        for(int a=0;a<N+1;a++){
            for(int b=0;b<N+1;b++){
                t[a][b]=-1;
            }
        }
        return solve (arr,i,j);
    }
    
     static int solve(int arr[], int i,int j){
         
        if(i>=j)
            return 0;
            
        if(t[i][j]!=-1)
            return t[i][j];
            
    
        int min= Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans=solve(arr,i,k)+ solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];

            if(tempans<min)
                min=tempans;
        }
        return t[i][j]=min;
     }
}

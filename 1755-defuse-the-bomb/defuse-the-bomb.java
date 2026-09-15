class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] res=new int[n];
        if(k==0){
            return res;

        }
        int st=1,end=k;
        if(k<0){
            st=n+k;
        
        end=n-1;
        }
    int wnsum=0;
    for(int i=st;i<=end;i++){
           
          wnsum+=code[i];
    }
    for(int i=0;i<n;i++){
        res[i]=wnsum;
        wnsum-=code[st%n];st++;
           wnsum+=code[(end+1)%n];end++;
    }
    return res;
}
}

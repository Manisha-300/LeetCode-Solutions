class Solution {
    public int fib(int n) {
        // if(n==0) return 0;
        // if(n==1) return 1;
        // int f1=0;
        // int f2=1;
        // int sum=0;
        // for(int i=0;i<=n;i++){
        //     sum=f1+f2;
        //     f1=f2;
        //     f2= sum; 
        // }
        // return sum;

    //     if(n==0 || n==1)
    //     {
    //         return n;
    //     }

    //     return fib(n-1)+fib(n-2);
        if(n==0 || n==1)
        {
            return n;
        }
    
        int a=0;
        int b=1;
        int c=0;
        //int n=3;
        for(int i=0;i<n-1;i++)
        {
            c=a+b;
            a=b;
            b=c;
           // System.out.println(c);
        }
       // System.out.println(c);
       return c;
     }

}
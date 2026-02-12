class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(nums.length==0) return 0;
        int [] t=new int [n];
        int size=0;
        for(int num :nums){
            int left=0;
        int right=size;
              while(left<right){
                int mid=left+(right-left)/2;
                if(t[mid]<num){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
              }
            
                t[left]=num;
                if(left==size) size++;
               
              
        }
              return size;
        
    }
}
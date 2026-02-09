class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int left=0;
       int sum=0;
       int lun=Integer.MAX_VALUE;
       for(int r=0;r<nums.length;r++){
        sum+=nums[r];
        while(sum>=target){
        lun=Math.min(lun,r-left+1);
          sum-=nums[left];
         left++;
       }
       }
     return (lun==Integer.MAX_VALUE)? 0:lun;
    }
}
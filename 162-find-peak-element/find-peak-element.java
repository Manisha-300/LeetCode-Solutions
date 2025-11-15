class Solution {
    public int findPeakElement(int[] a) {
         int n = a.length;
        int st = 0, end = n-1;
        while(st < end){
            int mid = st + (end-st)/2;
            if(a[mid] > a[mid+1]){
                end = mid;
            } else {
                st = mid+1;
            }
        }
        return st;
    }
}
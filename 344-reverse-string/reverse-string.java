class Solution {
    public void reverseString(char[] s) {
      int left=0,right=s.length-1;
      while(left<right){
        char ch=s[left];
        s[left]=s[right];
        s[right]=ch;
        left++;
        right--;
      }
    for(int i=0;i<s.length;i++){
        System.out.print(s[i]);
    }
        
    }
}
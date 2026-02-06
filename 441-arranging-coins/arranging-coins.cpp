class Solution {
public:
    int arrangeCoins(int n) {
        int ro=1;
        while(n>=ro){
            n=n-ro;
            ro++;
        }
        return ro-1;
    }
};
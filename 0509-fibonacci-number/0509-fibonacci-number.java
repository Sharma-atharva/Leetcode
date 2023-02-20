class Solution {
    public int fib(int n) {
        //int start =0;
        //int ft=1;
        if(n<2){
            return n;
        }
        return fib(n-1) +fib(n-2);
        
        
    }
}
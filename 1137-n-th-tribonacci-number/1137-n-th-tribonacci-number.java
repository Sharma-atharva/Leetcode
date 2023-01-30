class Solution {
    public int tribonacci(int n) {
        // initialize 3 numbers
        int a = 0;
        int b = 1;
        int c = 1;
        int i = 0;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        while(i < n - 2) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
            i ++; 
        }
        return c;
    }
}
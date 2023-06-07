class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(a!=0 || b!=0 || c!=0){
            
            int x1= a&1;
            int x2= b&1;
            int x3= c&1;
            
            if((x1 | x2)!=x3){
                count++;
                
                if((x1 & x2)==1)
                    count++;
            }
                        
            a=a>>1;
            b=b>>1;
            c=c>>1;
        }
        return count;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE; //Maximum Sum
        int cs = 0; //Current Sum
        for (int i = 0; i < nums.length; i++) {
            cs += nums[i];
            ms= Math.max(ms, cs);
            if (cs < 0){
                cs = 0;
            }        
        }
        return ms;
    }
}
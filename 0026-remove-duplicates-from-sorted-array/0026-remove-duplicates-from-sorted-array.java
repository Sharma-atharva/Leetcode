class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]!=nums[j]){
            //for(int j=i+1;j<=nums.length-1;j++){
                nums[j+1]=nums[i];
                    j++;
                 }
                
                
                
            
            
      }
        return j+1;
        
    }
   // return j+1;
}
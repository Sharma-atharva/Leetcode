class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
     
            int s = 0;
            int e = nums.length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid]==target){
                    return true;
                }
                else if(nums[mid]<target){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        
        return false;
    }
}
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        
        //similar approach as that of LIS
        
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int[] res = new int[nums.length];
        res[0] = 1;
        
        for(int i=1; i<len; i++) {
            
            int currNum = nums[i];
            
            if(currNum >= list.get(list.size()-1)) {
                list.add(currNum);
                res[i] = list.size();
            } else {
                
                //we do a binary search of the index where we have to replace with currNum in list
                int replaceIndex = binarySearch(currNum, list);
                list.set(replaceIndex, currNum);
                res[i] = replaceIndex +1;
            }
        }
        
        return res;
        
    }
    
    public int binarySearch(int currNum, List<Integer> list) {
        
        int left = 0; 
        int right = list.size()-1;
        
        while(left < right) {
            int mid = (left+right)/2;
            
            if(list.get(mid) <= currNum) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
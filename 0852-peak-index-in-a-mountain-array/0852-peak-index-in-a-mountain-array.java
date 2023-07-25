class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max=0;
        for(int i=0;i<arr.length-1;i++){
            // int max=0;
            if(arr[i]>arr[i+1]){
                max=i;
                break;
            
            }
            // return max;
        }
        return max;
        
        
     }
}
class Solution {
    public int maximumScore(int[] arr, int k) {
        int n = arr.length;
        int i=k;
        int j=k;

        int ans = arr[k];
        int min = arr[k];

        while(i>0 || j<n-1){
            if(i==0) ++j;
            else if(j==n-1) --i;
            else if(arr[i-1]<arr[j+1]) ++j;
            else --i;

            min = Math.min(min,Math.min(arr[i],arr[j]));
            ans = Math.max(ans,min*(j-i+1));
        }

        return ans;
    }
}
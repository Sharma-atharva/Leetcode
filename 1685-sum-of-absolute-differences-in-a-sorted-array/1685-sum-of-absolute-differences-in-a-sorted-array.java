class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        // Initialize prefix sum array
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        // Initialize result array
        int[] ans = new int[nums.length];

        // Step 1: Compute the prefix sum array
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        // Step 2: Calculate the left and right sums
        ans[0] = sum[nums.length - 1] - (nums[0] * nums.length);
        for (int i = 1; i < nums.length; i++) {
            // Calculate right sum
            int rightSum = (sum[nums.length - 1] - sum[i - 1]) - ((nums.length - i) * nums[i]);

            // Calculate left sum
            int leftSum = (nums[i] * i) - sum[i - 1];

            // Step 3: Update result array
            ans[i] = rightSum + leftSum;
        }

        // Step 4: Return the final result array
        return ans;
    }
}
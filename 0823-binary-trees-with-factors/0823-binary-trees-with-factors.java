class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> mp = new HashMap<>();
        long res = 1;
        Arrays.sort(arr);
        mp.put(arr[0], res);
        
        for (int k = 1; k < arr.length; k++) {
            long sum = 1;
            for (int i = 0; i < k; i++) {
                if (arr[k] % arr[i] == 0 && mp.containsKey(arr[k] / arr[i])) {
                    sum += (mp.get(arr[k] / arr[i]) * mp.get(arr[i]));
                }
            }
            mp.put(arr[k], sum);
            res += sum;
        }
        
        return (int) (res % 1_000_000_007);
    }
}
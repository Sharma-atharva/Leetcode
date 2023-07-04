class Solution {
    public int singleNumber(int[] nums) {
        // Create a hash map to store the count of each number
        Map<Integer, Integer> map = new HashMap<>();

        // Variable to store the single number
        int single = 0;

        // Iterate through the array
        for (int num : nums) {
            // If the number is not present in the map, add it with a count of 1
            if (!map.containsKey(num))
                map.put(num, 1);
            // If the number is already present, increment its count
            else
                map.put(num, map.get(num) + 1);
        }

        // Iterate through the map entries
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // If the count is 1, assign the key (the single number) to the `single` variable
            if (entry.getValue() == 1) {
                single = entry.getKey();
                // Break the loop as we have found the single number
                break;
            }
        }

        // Return the single number
        return single;
    }
}
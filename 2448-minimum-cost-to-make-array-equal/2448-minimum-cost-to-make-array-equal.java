import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class WeightedNum implements Comparable<WeightedNum> {
    public int num;
    public int weight;

    public WeightedNum(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedNum other) {
        return num - other.num;
    }
}

class Solution {
    public long minCost(int[] nums, int[] cost) {
        List<WeightedNum> weightedNums = IntStream
                .range(0, nums.length)
                .boxed()
                .map(i -> new WeightedNum(nums[i], cost[i]))
                .sorted()
                .toList();

        long totalWeight = 0;
        for (int weight : cost) totalWeight += weight;
		
        long currentRunningWeight = 0L;
        int numberToMinimizeTo = 0;
        for (WeightedNum weightedNum : weightedNums) {
            currentRunningWeight += weightedNum.weight;
			
			// If weight tips above 50% percentile we found the target num
            if ((double) currentRunningWeight / (double) totalWeight >= 0.5) {
                numberToMinimizeTo = weightedNum.num;
                break;
            }
        }

       final int number = numberToMinimizeTo;
       return weightedNums
               .stream()
               .filter(x -> x.num != number)
               .reduce(0L, (acc, weightedNum) -> acc + (long)Math.abs(weightedNum.num - number) * weightedNum.weight, Long::sum);

    }
}
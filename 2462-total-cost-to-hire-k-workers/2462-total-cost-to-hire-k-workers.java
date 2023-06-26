class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int n = costs.length;
        Queue<Integer> startPq = new PriorityQueue<>();
        Queue<Integer> endPq = new PriorityQueue<>();
        
        for (int i=0; i < Math.min(n, candidates); i++) {
            startPq.offer(costs[i]);
        }

        for (int i=n-1; i >= Math.max(n - candidates, candidates); i--) {
            endPq.offer(costs[i]);
        }        
        
        int left = candidates, right = n - candidates - 1;
        
        // System.out.println(left + " " + right);
        
        while (k-- > 0) {
            
            if (!startPq.isEmpty() && !endPq.isEmpty()) {
                if (startPq.peek() <= endPq.peek()) {
                    cost += startPq.poll();   
                    
                    if (left <= right) {
                        startPq.offer(costs[left]);
                        left++;
                    }
                } else {
                    cost += endPq.poll();
                    
                    if (left <= right) {
                        endPq.offer(costs[right]);
                        right--;
                    }
                }
            } else if (!startPq.isEmpty()) {
                cost += startPq.poll();
            } else if (!endPq.isEmpty()) {
                cost += endPq.poll();
            }
        }
        
        return cost;
    }
}
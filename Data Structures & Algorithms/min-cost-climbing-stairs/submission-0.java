class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 2];
        for(int i = cost.length - 1; i>= 0; i--) {
            result[i] = cost[i] + Math.min(result[i+1], result[i+2]);
        }
        return Math.min(result[0], result[1]);
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int minPositive = Integer.MAX_VALUE;
        var map = new HashSet<Integer>();
        for (int n : nums) {
            minPositive = n > 0 ? Math.min(minPositive, n) : minPositive;
            if (n > 0) {
                map.add(n);
            }
        }
        if (minPositive > 1) {
            return 1;
        } else {
            while (map.contains(minPositive)) {
                minPositive++;
            }
        }
        return minPositive;
    }
}
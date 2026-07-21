class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        var prefixSumMap = new HashMap<Integer, Integer>();
        prefixSumMap.put(0, 1);
        for(int n : nums) {
            sum += n;
            int diff = sum -k;
            count += prefixSumMap.getOrDefault(diff, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
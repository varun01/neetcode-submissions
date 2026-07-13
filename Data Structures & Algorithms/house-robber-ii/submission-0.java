class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int r1 = 0, r2 = 0;
        for (int n = 0; n < nums.length - 1; n++) {
            int temp = Math.max(nums[n] + r1, r2);
            r1 = r2;
            r2 = temp;
        }
        int res1 = r2;
        r1= 0; r2 = 0;
        for(int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i] + r1, r2);
            r1 = r2;
            r2 = temp;
        }
        return Math.max(res1, r2);
    }
}

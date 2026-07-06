class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 1;
        arr[1] = 1;
        return find(n, arr);
    }

    private int find(int n, int[] arr) {
        if(arr[n] != -1) {
            return arr[n];
        }

        arr[n] = find(n-1, arr) + find(n-2, arr);
        return arr[n];
    }
}

class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        return find(n, arr);
    }

    private int find(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        int res = 0;
        res = find(n - 1, arr) + find(n - 2, arr) + find(n - 3, arr);
        arr[n] = res;
        return res;
    }
}
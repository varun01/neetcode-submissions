class Solution {
    public int[] plusOne(int[] digits) {
       int result = -1;
        int len = digits.length - 1;
        while (result != 0 && len >= 0) {
            result = digits[len] + 1;
            digits[len--] = result % 10;
            result = result / 10;
        }
        if (result == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        if (len == -1 && result == 1) {
            int i = digits.length - 1;
            res[0] = 1;
            while (i < digits.length) {
                res[i + 1] = digits[i++];
            }
        }
        return res; 
    }
}

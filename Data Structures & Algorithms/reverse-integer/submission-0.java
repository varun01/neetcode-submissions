class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean flag = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            int digit = x % 10;
            if(result > (Integer.MAX_VALUE - digit)/10){
                return 0;
            }
            result = result * 10 + digit;
            x = x / 10;
        }
        return flag ? -result : result;
    }
}

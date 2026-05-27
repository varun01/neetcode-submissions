class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        double result = 0;
        if(n == 1)
            return true;
        while(temp > 1) {
            while (temp > 0) {
                result = result + Math.pow(temp%10,2);
                temp = temp/10;
            }
            if (result == 1) {
                return true;
            } else if (result < 7){
                return false;
            }
            temp = (int)result;
            result = 0;
        }
        return false;
    }
}

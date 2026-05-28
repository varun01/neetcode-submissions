class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                tens++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && tens > 0) {
                    five--;
                    tens--;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
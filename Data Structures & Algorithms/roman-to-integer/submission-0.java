class Solution {
    public int romanToInt(String s) {
        var map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char curr;
        char lastChar = '\0';
        char[] cArr = s.toCharArray();
        int i = cArr.length - 1;
        int result = 0;
        while (i >= 0) {
            curr = cArr[i--];
            if (lastChar != '\0') {
                if (curr == 'I' && (lastChar == 'V' || lastChar == 'X')) {
                    result -= 1;
                    continue;
                } else if(curr == 'X' && (lastChar == 'L' || lastChar == 'C')) {
                    result -= 10;
                    continue;
                } else if (curr == 'C' && (lastChar == 'D' || lastChar == 'M')) {
                    result -= 100;
                    continue;
                }
            }
            result = result + map.get(curr);
            lastChar = curr;
        }
        return result;
    }
}
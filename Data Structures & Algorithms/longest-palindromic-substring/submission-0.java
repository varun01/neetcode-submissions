class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int resultLen = 0;
        String result = "";
        int i = 0;
        int length = s.length();
        while(i < length) {
            left = i;
            right = i;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resultLen) {
                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resultLen) {
                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left--;
                right++;
            }
            i++;
        }
        return result;
    }
}

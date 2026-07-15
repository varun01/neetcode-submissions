class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        int i = 0;
        while (i < s.length()) {
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
            i++;
        }
        return result;
    }
}

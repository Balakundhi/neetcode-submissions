class Solution {

    private int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            int oddCheck = expand(s, i, i);
            int evenCheck = expand(s, i, i+1);

            int length = Math.max(oddCheck, evenCheck);

            if(length > maxLength){
                maxLength = length;
                start = i - (length-1)/2;
            }
        }
        return s.substring(start, start + maxLength);
    }
}

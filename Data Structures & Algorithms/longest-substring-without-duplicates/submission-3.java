class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while(right < s.length()){
            if(hash[s.charAt(right)] >= left){
                left = hash[s.charAt(right)] + 1;
            }

            count = Math.max(count, right-left+1);
            hash[s.charAt(right)] = right;
            right++;
        }

        return count;
    }
}

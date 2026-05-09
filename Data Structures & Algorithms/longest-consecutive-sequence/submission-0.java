class Solution {
    public int longestConsecutive(int[] nums) {
        // since sorting is not allowed - I use set and then check its neighbouring elements

        if(nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }


        for(int s : set){
            if(!set.contains(s-1)){
                int start = s;
                int count = 1;
            
                while(set.contains(start+1)){
                    start = start + 1;
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}

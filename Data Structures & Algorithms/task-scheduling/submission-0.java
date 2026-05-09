class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for(char c : tasks){
            hash[c - 'A']++;
        }

        int maxFreq = 0;
        int maxCount = 0;

        for(int num : hash){
            if(num > maxFreq){
                maxFreq = num;
                maxCount = 1;
            } else if (num == maxFreq){
                maxCount++;
            }
        }

        int interval = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(interval, tasks.length);
    }
}

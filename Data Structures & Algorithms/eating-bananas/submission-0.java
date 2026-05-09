class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
          max = Math.max(p, max);
        }

        // Binary search
        int left = 0;
        int right = max;

        while(left < right){
            int mid = left + (right - left)/2;
            int totalHours = 0;

            for(int pile : piles){
                totalHours += Math.ceil((double)pile / (double)mid);
            }

            if(totalHours <= h){
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}

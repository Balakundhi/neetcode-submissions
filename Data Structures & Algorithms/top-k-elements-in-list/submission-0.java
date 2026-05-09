class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // step 1 - Initialize a map and put the number and its frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n , map.getOrDefault(n, 0) +1);
        }

        // step 2 - initialize the bucket which is a int array consisting of list
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0; i<bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }

        //step 3 - traverse the map and fill the bucket -- key = count and value = number
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int count = entry.getValue();
            bucket[count].add(number);
        }

        int[] result = new int[k];
        int index = 0;

        // step 4 - walk backward to find the k most frequent
        for(int i=bucket.length-1 ; i>=0 && index < k; i--){
            for(int num : bucket[i]){
                result[index] = num;
                index++;
                if(index == k) break;
            }
        }

        return result;
    }
}

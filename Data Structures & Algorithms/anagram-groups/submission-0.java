class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] cA = s.toCharArray();
            Arrays.sort(cA);
            String sortedKey = new String(cA);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(s);
        }

        return new ArrayList(map.values());
    }
}

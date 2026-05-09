class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for( char c : s.toCharArray()){
            hash[c-'a']++;
        }

        int maxFreq = 0;
        int maxChar = 0;

        for(int i=0; i<26; i++){
            if(hash[i] > maxFreq){
                maxFreq = hash[i];
                maxChar = i;
            }
        }

        if(maxFreq > (s.length()+1)/2) return "";

        char[] result = new char[s.length()];
        int index = 0;

        while(hash[maxChar] > 0){
            result[index] = (char) (maxChar + 'a');
            index += 2;
            hash[maxChar]--;
        }

        for(int i=0; i<26; i++){
            while(hash[i] > 0){
                if(index >= s.length()) index = 1;
                result[index] = (char) (i+'a');
                index += 2;
                hash[i]--;
            }
        }

        return new String(result);
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int min_Length = Integer.MAX_VALUE;
        String ans = "";
        // Putting occurences of each character of t into to a HashMap.
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int no_of_char_must_be_there_in_final_answer = t.length();

        // We will be using the sliding window out here.
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);
            if (map.get(s.charAt(r)) >=0) no_of_char_must_be_there_in_final_answer--; 
            
            while (no_of_char_must_be_there_in_final_answer == 0) { // a possible answer is found we will try to shink it from the left
                if (r - l + 1 < min_Length) {
                    min_Length = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                if (map.get(s.charAt(l)) >= 1) no_of_char_must_be_there_in_final_answer++;
                l++;
            }

            r++;
        }
        return ans;
    }
}

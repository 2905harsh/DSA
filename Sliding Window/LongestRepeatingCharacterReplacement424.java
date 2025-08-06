class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; // max frequency of any character in current window
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            int windowLength = end - start + 1;
            int charsToReplace = windowLength - maxFreq;

            if (charsToReplace > k) {
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}

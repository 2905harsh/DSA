import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters03 {

  class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        // We are creating an Hashmap to store the visited characters with their index.
        HashMap<Character,Integer> db = new HashMap<>();
        // Now Using two pointers l and r and sliding window between l & r.
        int l = 0;
        for(int r=0; r <s.length();r++){
            char endChar = s.charAt(r);
            // we update the left when the character at the right is already present in the hashmap but it should also lie inside our sliding window means it should not before the left. Now left will we one step ahead of the previous occurence of that element.

            // After updating the left we will now update the position of that element at the right in hashmap for future. 

            if(db.containsKey(endChar) && db.get(endChar)>=l){
                l=db.get(endChar)+1;
                db.put(endChar,r);
            }

            // if the element at right index is not present in hashmap we will add them.
            else{
                  db.put(endChar,r);
            }
            maxLength = Math.max(maxLength,r-l+1);

        }
        return maxLength;
    }
}
// Do a proper dry run for more understanding.
}

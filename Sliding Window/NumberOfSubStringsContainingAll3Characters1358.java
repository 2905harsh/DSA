import java.util.Collections;
import java.util.HashMap;

public class NumberOfSubStringsContainingAll3Characters1358 {
  class Solution {
    public int numberOfSubstrings(String s) {
        // Will make a HashMap that will store the character and its index on which it was seen last.
        HashMap<Character,Integer> map = new HashMap<>();
        // maintaining a pointer that will traverse through the entire string .
        int r = 0;
        // This variable will maintain the final answer that we will return .
        int count = 0;
      
// At every element will simply add that element into the hash map with its index, and then we check whether the HashMap contain all the three characters or not. If it have all the three characters then definitely, we can make a suitable substring that will contain all three character, but if not, we'll move to the next character.

// The main point occurs when we get the three elements in our hash map, then the minimum value from hash map will be the starting index of our suitable substring.Also, the indexes which is before the starting index of our correct substring, can also contribute to make a correct substring.So we derive a simple mathematical formula to add all these substring is we can just simply count the (minimum value of HashMap + 1) .It ensures that you have selected the all the previous indexes that can make suitable substring.
// For Eg
// b b a c b a
// 0 1 2 3 4 5 
// r=0 hashmap will be |b-0| .              We can't make a suitable substring
// r=1 hashmap will be |b-1| .              We can't make a suitable substring
// r=2 hashmap will be |b-1 , a-2| .        We can't make a suitable substring
// r=3 hashmap will be |b-1 , a-2 , c-3|  . Now we can make a suitable substring 
// min value from hashmap will be 1 .
// Now add 1 to it then it beacomes 2.
// So till now we can make 2 substring that will contain all three characters.
// Those will be 'bac' and 'bbac'.
// Now r will go to 4 and same goes on like that.

        while(r<s.length()){
            map.put(s.charAt(r),r);
            if(map.size()==3){
               count=count+Collections.min(map.values())+1;
            }
            r++;
        }
        return count
    }
}

}


// ALERNATE SOLUTION

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;
        while (r < s.length()) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() == 3) {
                count += s.length()-1-(r+1)+1 +1 ;
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }

            r++;

        }
        return count;

    }
}

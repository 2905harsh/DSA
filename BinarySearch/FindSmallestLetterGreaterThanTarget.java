public class FindSmallestLetterGreaterThanTarget{

  public static void main(String[] args) {
    char []letters = {'c','f','j'};
    char target = 'a';
    char result = nextGreatestLetter(letters, target);
    System.out.println(result); 
    
    
  }
  public static char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length-1;
        int mid;
        while(s<=e){
            mid=(s+e)/2;
            if (letters[mid]==target) s =mid+1;
            if(letters[mid]>target) e = mid-1 ;
            if(letters[mid]<target) s =mid+1;
        }
        return letters[s%(letters.length)] ;
        
    }
}

// Question link 
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
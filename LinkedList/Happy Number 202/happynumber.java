package HappyNumber202;

public class happynumber {
  class Solution {
    public boolean isHappy(int n) {

     // This is solved using the slow and fast pointer approach , we use in linked list cycle detection .
     int slow = findSumOfSquareOfDigitsOfANumber(n);
     int fast  = findSumOfSquareOfDigitsOfANumber(n);

     do{
        slow = findSumOfSquareOfDigitsOfANumber(slow);
        fast = findSumOfSquareOfDigitsOfANumber(findSumOfSquareOfDigitsOfANumber(fast));

     }while(slow!=fast);

     if(slow==1) return true;

     return false;
     }

    public int findSumOfSquareOfDigitsOfANumber(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans += rem*rem;
            n = n/10; 
        }
        return ans;
    }
}
}
// This is leetcode problem 202 . HappyNumber

/*
  1. Helper Function
	•	findSumOfSquareOfDigitsOfANumber(n) takes O(log n) time.
	•	Because n has ≈ log₁₀(n) digits.
  
  2. Main Loop
	•	Uses Floyd’s Cycle Detection (slow & fast pointers).
	•	Number of iterations is bounded (max sum of squares ≤ 243).
	•	So only a constant number of steps.


Time Complexity: O(log n)
(Each step is O(log n), number of steps is constant)

 Space Complexity: O(1)
(Uses only a few integer variables)
 */

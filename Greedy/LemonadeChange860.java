/*
 Lemonade Change - Problem Summary

Each lemonade costs $5.

Customers queue up and pay one at a time with either:
- $5
- $10
- $20

You must give back the correct change for each transaction.
You start with no change in hand.

Return true if you can give correct change to every customer.
Otherwise, return false.

Example:
Input:  [5, 5, 5, 10, 20]
Output: true

Explanation:
- Customer 1: pays $5 → no change
- Customer 2: pays $5 → no change
- Customer 3: pays $5 → no change
- Customer 4: pays $10 → give $5 as change
- Customer 5: pays $20 → give $10 and $5 as change

Constraints:
- 1 <= bills.length <= 10^4
- bills[i] is 5, 10, or 20
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int x=0; // Tracks number of 5 rupee coin we have
        int y=0; // Tracks number of 10 rupee coin we have
        
        for(int current : bills){

             // If we get 5 rupee coin from customer
             if(current==5) x++;

             // If we get 10 rupee coin from customer
             else if(current==10){
                // If we have no 5 rupee coin to give change then we cannot handle him.
                if(x==0) return false;
                // If we can handle him just increase the number of 10 coin by 1 and decrease number of 5 coin by 1.
                else{
                    x--;
                    y++;
                }
             }

             // If we get 20 rupee coin from customer we will first check if we have one 10 rupee coin and one 5 rupee coin.
             // If this not works then we will check if we have three 5 rupeee coin. 
             // If both not works then sorry we cannot handle him.
             else if(current==20){
               if( y>0 && x>0){
                    y--;
                    x--;
                }
               else if(x>=3){
                      x=x-3;
                }
                else{
                    return false;
                }
                
            }
    }
    return true;
}
}



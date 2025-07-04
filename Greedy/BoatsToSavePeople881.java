/*Question Explanation: Boats to Save People

You're given an array `people` where each element is a person's weight, and a `limit` which is the **maximum weight a boat can carry.

- Each boat can carry at most 2 people.
- The total weight in one boat must be less than or equal to limit.
- You have unlimited boats.

Goal:
Return the minimum number of boats needed to carry all people.

Example 1:

people = [3, 2, 2, 1], limit = 3

Output: 3

Explanation:
- Boat 1: 1 + 2 = 3
- Boat 2: 2 (alone)
- Boat 3: 3 (alone)

Example 2:

people = [3, 5, 3, 4], limit = 5

Output: 4

Explanation:
- Boat 1: 3 (alone)
- Boat 2: 3 (alone)
- Boat 3: 4 (alone)
- Boat 4: 5 (alone)
*/

// Approach:
//We will first sort the array.
// Then will we use 2 pointers l and r
// l will be at the starting of the sorted array pointing to lowest weight among all.
// r will be at the end of the sorted array pointing to the highest weight among all.
// We will find a maximum combination of weight of 2 people that can fit in a boat.
// If sum of weight exceeds then we will r towards left until they can together fit in boat.
// Once both the person fits in boat we will update their weight as -1.
// We will maintain the distance 'sv' r-pointer covers from right most person whom boat is not assigned.
// Once both the person fits in boat we will move l one step forward and r to that rightmost person waiting for boat.
// If in case both pointer points to same person means he cannot go with anyone . So give him a separate boat.
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sv =0;
        int l=0;
        int r = people.length-1;
        int boat=0;
        while(l<people.length){
            if(people[l]==-1) l++;
            else if(l==r){
                 boat++;
                 l++;
                 people[r]=-1;
                 r+=sv;
                 sv=0;
            }
            else if(people[r]==-1){
                r--;
                sv++;
            }
            else if(people[l]+people[r]>limit){
                r--;
                sv++;
            }
            else if (people[l]+people[r]<=limit){
                people[l]=-1;
                people[r]=-1;
                boat++;
                l++;
                r+=sv;
                sv=0;
            }
        }
        return boat;
    }
}
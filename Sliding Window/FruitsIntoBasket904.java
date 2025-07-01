import java.util.HashMap;

public class FruitsIntoBasket904 {
  class Solution {
    public int totalFruit(int[] arr) {
      // HashMap is created to store the which type of fruit had come how many times.
      // (type of fruit , it's frequency).
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = arr.length;
      if (n == 1)
        return 1;
      // Here we will be using two pointers approach l and r .
      // We will be maintaining a sliding window between l and r .

      int l = 0;
      int ans = 0;
      int r = l + 1;
      map.put(arr[l], map.getOrDefault(arr[l], 0) + 1);
      // Loop will run till the last element of the array.
      while (r < n) {

        // We can have maximum size of hashmap as 2.Beacuse we have only two basket
        // which can accomodate atmost 2 types of fruits.

        // 1. This condition if the size of hashmap is less than 2 then simply add that
        // type of new fruits.But if the size is already 2 but the element you have
        // right now have already some occurences before.So we will simply update its
        // value.
        if (map.size() < 2 || map.get(arr[r]) != null) {
          map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
          ans = Math.max(ans, r - l + 1);
        }
        // 2 . This loop will work when the size is already 2 and you have a new element
        // to add. So in this case we will remove occurences of fruits that is present
        // on the left pointer but remember do remove each occurence of fruit that is on
        // the left . When the occurence of that becomes 0 remove that type of fruit
        // from hashmap
        else {
          while (map.size() == 2) {
            map.put(arr[l], map.get(arr[l]) - 1);
            if (map.get(arr[l]) == 0) {
              map.remove(arr[l]);
            }
            l++;

          }
          map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
          ans = Math.max(ans, r - l + 1);
        }
        r++;
      }
      return ans;
    }
  }

}

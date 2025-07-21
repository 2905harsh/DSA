// For every diagonal the value of i-j remains constant.
// We will make the every unique i-j value as a key in hashmap .
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[i].length;j++){
            List<Integer> l  = map.getOrDefault(i-j,new ArrayList<>());
            l.add(mat[i][j]);
            map.put(i-j,l);
             }
        }

       // Sorting each individual lists in hashmap.
        for (List<Integer> list : map.values()) {
            Collections.sort(list);  
        }

        // Updating the sorted values in the original mat array.
        for(int  i = mat.length-1 ; i>=0 ; i--){
            for(int j = mat[i].length-1 ; j>=0 ; j--){
                mat[i][j] = map.get(i-j).get(map.get(i-j).size()-1);
                map.get(i-j).remove(map.get(i-j).size()-1);
            }
        }
        return mat;
    }
}

https://drive.google.com/file/d/14Oh0B7fxnP3jWwwnYo18WOWi5VUBCwFS/view?usp=drive_link

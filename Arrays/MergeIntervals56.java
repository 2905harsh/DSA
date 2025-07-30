class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        // Sorting the 2d array based on the first member row-wise.
        Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        int l = intervals.length;
        int iStart = intervals[0][0];
        int tempEnd = intervals[0][1];
        int i = 0;
        while (i < l) {
            i++;
            while (i < l && intervals[i][0] <= tempEnd) {
                tempEnd = Math.max(intervals[i][1],tempEnd);
                i++;
            }
            List<Integer> itr = new ArrayList<>();
            itr.add(iStart);
            itr.add(tempEnd);
            ans.add(itr);
            if(i<l){
            iStart = intervals[i][0];
            tempEnd = intervals[i][1];
            }
        
        }

        // Converting list of lists to 2D matrix.
        int[][] result = new int[ans.size()][2];

        for (int r = 0; r < ans.size(); r++) {
            List<Integer> row = ans.get(r);
            for (int j = 0; j < row.size(); j++) {
                result[r][j] = row.get(j);
            }
        }
        return result;
     }
}
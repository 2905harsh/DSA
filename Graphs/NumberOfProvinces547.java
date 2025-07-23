class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int NoOfProvinces = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i =0 ; i<n; i++){
            if(visited[i]==false){
                q.add(i);
                NoOfProvinces++;
                visited[i]=true;
            }
            // BFS ALGO . 
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j = 0 ; j<n ; j++){
                    if(isConnected[curr][j]==1 && !visited[j]){
                    q.add(j);
                    visited[j]=true;
                    }
                }
            }
        }
        return NoOfProvinces;
    }
}


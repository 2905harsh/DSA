// bfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        //-1 will show the uncolored & unvisited node.
        // 0 will show visited and marked with blue.
        // 1 will show visited and marked with red.

        for (int start = 0; start < graph.length; start++) {
            if (visited[start] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                visited[start] = 1;
                while (!q.isEmpty()) {
                int parent = q.remove();
                int[] neighbours = graph[parent];
                for (int neighbour : neighbours) {
                    if (visited[parent] == visited[neighbour]) return false;
                    else if (visited[neighbour] == -1) {
                        visited[neighbour] = 1 - visited[parent];
                        q.add(neighbour);
                    }
                }
                }
            }
    }
       return true;
    }
}

// dfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        //-1 will show the uncolored & unvisited node.
        // 0 will show visited and marked with blue.
        // 1 will show visited and marked with red.

        for(int node = 0 ; node<graph.length;node++){
            if(visited[node]==-1){
                visited[node]=1;
                if(dfs(graph,visited,node)==false) return false;
            }
        }
        return true;

        
    }

    public boolean dfs(int[][] graph ,int[] visited,int node){
        for(int neighbour : graph[node]){
            if(visited[neighbour]==visited[node]) return false;
            if(visited[neighbour]==-1){
                visited[neighbour]=1-visited[node];
                if(dfs(graph,visited,neighbour)==false) return false;
            }
        }
        return true;
    }
}




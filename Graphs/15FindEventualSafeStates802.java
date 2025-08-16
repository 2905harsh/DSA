class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        int V = graph.length;
        boolean [] visited = new boolean[V];
        Arrays.fill(visited,false);
        boolean []pathVisited = new boolean[V];
        Arrays.fill(pathVisited,false);
        
        for(int node=0;node<V;node++){
            if(visited[node]==false){
                dfs(graph,visited,pathVisited,node);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i =0 ; i<pathVisited.length;i++){
            if(pathVisited[i]==false) ans.add(i);
        }
        return ans;
        
    }

    public boolean dfs(int[][] graph,boolean [] visited,boolean []pathVisited,int node){
        visited[node]=true;
        pathVisited[node]=true;
        
        for(int neighbour : graph[node]){
            if(visited[neighbour]==false){
                if(dfs(graph,visited,pathVisited,neighbour)==true) return true;
            }
            else if(visited[neighbour] && pathVisited[neighbour]){
                return true;
            }
        }
        
        pathVisited[node]=false;
        return false;
        
    }

}
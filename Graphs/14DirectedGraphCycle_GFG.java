// Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Let us first make adjacency list from edge-list.
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            int u =edge[0];
            int v =edge[1];
            List<Integer> temp = map.getOrDefault(u,new ArrayList<>());
            temp.add(v);
            map.put(u,temp);
        }
        
        boolean [] visited = new boolean[V];
        Arrays.fill(visited,false);
        boolean []pathVisited = new boolean[V];
        Arrays.fill(pathVisited,false);
        
        for(int node=0;node<V;node++){
            if(visited[node]==false){
                if(dfs(map,visited,pathVisited,node)==true) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(HashMap<Integer,List<Integer>> map,boolean [] visited,boolean []pathVisited,int node){
        visited[node]=true;
        pathVisited[node]=true;
        
        for(int neighbour : map.getOrDefault(node,new ArrayList<>())){
            if(visited[neighbour]==false){
                if(dfs(map,visited,pathVisited,neighbour)==true) return true;
            }
            else if(visited[neighbour] && pathVisited[neighbour]){
                return true;
            }
        }
        
        pathVisited[node]=false;
        return false;
        
    }
}

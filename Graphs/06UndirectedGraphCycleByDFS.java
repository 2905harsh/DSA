class Solution {
    
    public boolean isCycle(int V, int[][] edges) {
        // Making Adjacency list from edge list.
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int [] ele : edges){
            int u = ele[0];
            int v = ele[1];
            List<Integer> temp1 = map.getOrDefault(u,new ArrayList<>());
            temp1.add(v);
            map.put(u,temp1);
            List<Integer> temp2 = map.getOrDefault(v,new ArrayList<>());
            temp2.add(u);
            map.put(v,temp2);
        }
        
        boolean [] visited = new boolean[V];
        Arrays.fill(visited,false);
        
        for(int vertex=0 ; vertex<V ;vertex++){
            if(visited[vertex]==false){
                if(detectCycleByDfs(vertex , -1 ,map , visited)==true) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycleByDfs(int currVertex , int parent ,HashMap<Integer,List<Integer>> map , boolean [] visited){
        visited[currVertex]=true;
        for(int neighbour : map.getOrDefault(currVertex,new ArrayList<>())){
            if(visited[neighbour]==false){
               if(detectCycleByDfs(neighbour,currVertex,map,visited)==true) return true;
            }
            else if(visited[neighbour]==true && neighbour!=parent) return true;
        }
        return false;
    }
}

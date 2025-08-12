class Solution {
    class pair{
        int Vertex;
        int FromWhereVertexCame;
        
        public pair(int Vertex, int FromWhereVertexCame){
            this.Vertex = Vertex;
            this.FromWhereVertexCame = FromWhereVertexCame;
        }
    }
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
        
        Queue<pair> q = new LinkedList<>();
        
         for(int vertex = 0 ; vertex<V ; vertex++){
             if(visited[vertex]==false){
                 q.add(new pair(vertex,-1));
                 visited[vertex]=true;
             }
             while(!q.isEmpty()){
                 pair curr = q.remove();
                 int currVertex = curr.Vertex;
                 int parent = curr.FromWhereVertexCame;
                 for(int neighbour : map.getOrDefault(currVertex,new ArrayList<>())){
                     if(visited[neighbour]==false){
                         q.add(new pair(neighbour,currVertex));
                         visited[neighbour]=true;
                     }
                     else if(visited[neighbour]==true){
                         if(neighbour !=parent) return true;
                     }
                 }
             }
         }
         return false;
    }
}








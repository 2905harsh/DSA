class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // making adjacency list from the given edge-list.
        HashMap <Integer , List<Integer>> map = new HashMap<>();
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            List<Integer> temp = map.getOrDefault(u,new ArrayList<>());
            temp.add(v);
            map.put(u,temp);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean [] visited = new boolean[V];
        Arrays.fill(visited,false);
        
        for(int node = 0 ; node<V ;node++){
            if(visited[node]==false){
                dfs(map,visited,node,st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
        
    }
    
    public static void dfs( HashMap <Integer , List<Integer>> map,boolean [] visited ,int node,Stack<Integer> st){
        visited[node]=true;
        for(int neighbour : map.getOrDefault(node,new ArrayList<>())){
            if(visited[neighbour]==false) dfs(map,visited,neighbour,st);
        }
        st.push(node);
    }
}

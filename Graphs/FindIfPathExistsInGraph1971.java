// Solution 1 using adjacency Matrix 
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // forming the adjacency Matrix
        boolean[][] graph = new boolean[n][n];
        for(boolean[] row : graph){
            Arrays.fill(row,false);
        }

        // filling the edges from the input to graph
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true; // because undirected/bidirected graph
        }

        // We will be using the BFS traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        // making the visited array.
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);


        visited[source] = true;

        while(!q.isEmpty()){
            int curr = q.remove();

            // checking if this node is our destination node then we will return true.
            if(curr == destination) return true;

            // Traversing each neighbour of curr
            for(int i = 0 ; i<n ;i++){
                if(graph[curr][i]==true && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }

        // if we came out without returning then destination is not connected to source
        return false;



    }
}


//  Solution 2 using adjacency list

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Creating the Adjacency List
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        // Entering the input to the hashmap.
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            List<Integer> temp1 = graph.getOrDefault(u,new ArrayList<>());
            temp1.add(v);

            List<Integer>  temp2 = graph.getOrDefault(v,new ArrayList<>());
            temp2.add(u);

            graph.put(u,temp1);
            graph.put(v,temp2);

        }
        
        // making the visited array so that we do not visit any node twice.
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);


        // Implementing the BFS So we required the Queue Data Structure.
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        visited[source] = true;

        while(!q.isEmpty()){
            int curr = q.remove();

            if(curr == destination) return true;

            for(int neighbour : graph.get(curr)){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour]= true;
                }
            }

        }
        return false;
    }
}

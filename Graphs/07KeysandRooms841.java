// by dfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(0,rooms,visited);

        for(boolean c: visited){
            if(c==false){
                return false;
            }
        }
        return true;
        
    }

    public void dfs(int currroom ,List<List<Integer>> rooms,  boolean [] visited ){
        visited[currroom] = true;
        for(int room : rooms.get(currroom)){
            if(visited[room]==false) dfs(room,rooms,visited);
        }
    }
}

// by bfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Lets Create a Adjacency list
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i =0 ; i<rooms.size() ; i++){
            List<Integer> temp = map.getOrDefault(i,new ArrayList<>());
            for(int room : rooms.get(i)){
                temp.add(room);
            }
            map.put(i,temp);
        }

        boolean [] visited = new boolean[rooms.size()];
        Arrays.fill(visited,false);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int neighbour : map.get(curr)){
               if(visited[neighbour]==false){
                   q.add(neighbour);
                   visited[neighbour]=true;
               }
            }
        }
        for(boolean c : visited){
            if(c==false) return false;
        }
        return true;
    }
}
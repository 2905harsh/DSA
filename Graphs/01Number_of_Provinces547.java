class Solution {
    public int findCircleNum(int[][] isConnected) {
        int NoOfVertices = isConnected[0].length;
        boolean[] visited = new boolean[NoOfVertices];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        int NoOfProvinces = 0;

        for (int i = 0; i < NoOfVertices; i++) {
            if (visited[i] == false) {
                q.add(i);
                visited[i] = true;
                NoOfProvinces++;
            }
            while (!q.isEmpty()) {
                int ele = q.remove();
                for (int j = 0; j < NoOfVertices; j++) {
                    if (isConnected[ele][j] == 1 && visited[j] == false) {
                        q.add(j);
                        visited[j]=true;
                    }
                }
            }
        }
        return NoOfProvinces;
    }
}

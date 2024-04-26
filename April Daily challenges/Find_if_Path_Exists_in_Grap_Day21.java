public class Find_if_Path_Exists_in_Grap_Day21 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // creating a adj list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        // fill values
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        boolean found = dfs(adjList,source, destination, visited);
        return found;

    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int curNode, int destination,boolean visited[]){
        visited[curNode] = true;
        if(curNode==destination){
            return true;

        }
        //visit all the neig of curNode
        for(int neighbour : adjList.get(curNode)){
            if(!visited[neighbour]){
                boolean found = dfs(adjList, neighbour, destination, visited);
                if(found){
                    return true;
                }
            }
        }
        return false;
    }
}

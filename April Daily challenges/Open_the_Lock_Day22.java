import java.util.ArrayList;

public class Open_the_lock_Day22 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // creating an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // fill values
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        boolean found = dfs(adjList, source, destination, visited);
        return found;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int curNode, int destination, boolean[] visited) {
        visited[curNode] = true;
        if (curNode == destination) {
            return true;
        }
        // visit all the neighbors of curNode
        for (int neighbour : adjList.get(curNode)) {
            if (!visited[neighbour]) {
                boolean found = dfs(adjList, neighbour, destination, visited);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPath validPath = new ValidPath();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        int source = 0;
        int destination = 4;
        boolean isValid = validPath.validPath(n, edges, source, destination);
        System.out.println("Is there a valid path from " + source + " to " + destination + "? " + isValid);
    }
}

//You are given row x col grid representing a map where grid[i][j] = 1
// represents land and grid[i][j] = 0 represents water.
//
//Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
// and there is exactly one island (i.e., one or more connected land cells).
//
//The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
// One cell is a square with side length 1.
// The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

public class Island_Perimeter_Day18 {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j]==1){
                    //up
                    if(i>0 && grid[i-1][j]==0 || i==0){
                        count+=1;
                    }
                    //right
                    if(j<cols-1 && grid[i][j+1]==0 || j==cols-1){
                        count+=1;
                    }
                    //down
                    if(i<rows-1 && grid[i+1][j]==0 || i==rows-1){
                        count+=1;
                    }
                    //left
                    if(j>0 && grid[i][j-1]==0 || j==0){
                        count+=1;
                    }

                }
            }
        }
        return count;
    }
}

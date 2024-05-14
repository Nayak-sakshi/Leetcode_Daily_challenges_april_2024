public class Minimum_Falling_Path_Sum_II_Day26 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // Get the size of the matrix
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE; // Initialize first and second minimums to a large value
        int firstIndex = -1, secondIndex = -1; // Initialize indices for the first and second minimums

        // Iterate through each row of the matrix
        for(int i = 0; i < n; i++) {
            if(i != 0) { // For rows after the first one
                // Update the matrix values based on previous row's minimums
                for(int j = 0; j < n; j++) {
                    if(j != firstIndex)
                        matrix[i][j] += firstMin;
                    else
                        matrix[i][j] += secondMin;
                }
            }

            // Reset first and second minimums for the current row
            firstMin = Integer.MAX_VALUE;
            secondMin = Integer.MAX_VALUE;

            // Iterate through each element of the current row
            for(int j = 0; j < n; j++) {
                // Update first and second minimums and their indices
                if(matrix[i][j] < firstMin) {
                    secondMin = firstMin;
                    firstMin = matrix[i][j];
                    firstIndex = j;
                } else if(matrix[i][j] < secondMin) {
                    secondMin = matrix[i][j];
                    secondIndex = j;
                }
            }
        }

        // Return the minimum of the first and second minimums
        return Math.min(firstMin, secondMin);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
        System.out.println(solution.minFallingPathSum(matrix)); // Output should be 13
    }
}

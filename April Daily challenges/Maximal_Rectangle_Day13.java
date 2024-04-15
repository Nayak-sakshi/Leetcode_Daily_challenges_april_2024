public class Maximal_Rectangle_Day13 {

        public int maximalRectangle(char[][] matrix) {
            // if there are no rowa then return
            if(matrix.length==0){
                return 0;
            }
            // find the number of column in a row.
            int heights[] = new int[matrix[0].length];
            int largest = 0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    int val = matrix[i][j]-'0';// char too int
                    if(val==0){
                        heights[j]= 0;
                    }else{
                        heights[j]+= val;
                    }
                }
                int maxArea = largestRectangleArea(heights);
                if(largest<maxArea){
                    largest = maxArea;
                }
            }
            return largest;
        }
        public int largestRectangleArea(int[] heights){
            //
            int stack[] = new int[heights.length];
            int index = -1;
            int max = 0;
            int n = heights.length;
            for(int i=0;i<n;i++){
                while(index!= -1 && heights[stack[index]]>heights[i]){
                    int h = heights[stack[index--]];
                    int ps = (index==-1)?-1:stack[index];
                    int w = i-ps-1;
                    max = Math.max(max, (h*w));

                }
                // stack.push();
                stack[++index] = i;
            }
            while(index!=-1){
                int h = heights[stack[index--]];
                int ps = (index==-1)?-1:stack[index];
                int w = n-ps-1;
                max = Math.max(max, (h*w));
            }
            return max;
        }
}

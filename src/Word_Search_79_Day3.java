//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cells,
//where adjacent cells are horizontally or vertically neighboring. The same letter
//cell may not be used more than once.

public class Word_Search_79_Day3 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}

        };
        String word = "ABCCED";

        // Create an instance of your class (assuming it's named something like WordSearch)
        Word_Search_79_Day3  wordSearch = new Word_Search_79_Day3 ();

        // Call the exist method and print its output directly
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n =board[0].length;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(word.charAt(0)==board[r][c]){
                    boolean found = dfs(board,r,c,word,0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int r, int c, String word, int wordIndex){
        // Base case
        //valid case
        if(wordIndex==word.length()){
            return true;
        }
        //Out of bounf Case
        int row = board.length;
        int cols = board[0].length;
        if(r<0 || c<0 || r>=row || c>=cols){
            return false;
        }
        //Invalid Cases
        if(board[r][c] ==' ' || board[r][c]!=word.charAt(wordIndex)){
            return false;
        }
        //Mark as Visited
        char ch = board[r][c];
        board[r][c] = ' ';
        // dfs calls

        if( dfs(board,r-1,c,word, wordIndex+1)||
                dfs(board,r,c+1,word, wordIndex+1)||
                dfs(board,r+1,c,word, wordIndex+1) ||
                dfs(board,r,c-1,word, wordIndex+1)){
            return true;
        }
        //Backtracking
        board[r][c] = ch;
        return false;
    }
}

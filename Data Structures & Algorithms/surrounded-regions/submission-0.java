class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }
        for(int r = 0; r < rows; r++) {
            if(board[r][cols-1] == 'O') {
                dfs(r, cols - 1, board);
            }
        }

        for(int c = cols - 1; c >= 0; c--) {
            if(board[rows - 1][c] == 'O') {
                dfs(rows- 1, c, board);
            }
        }

        for(int r = rows - 1; r >= 0 ; r--) {
            if(board[r][0] == 'O') {
                dfs(r, 0, board);
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if(board[i][j] == 'O') {
            board[i][j] = 'T';
        } else {
            return;
        }
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}

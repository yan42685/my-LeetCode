
//leetcode submit region begin(Prohibit modification and deletion)
// 将'O'分为两种，染色两遍
class Solution {
    private static final char TEMP = '#';

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int row = 0; row < board.length; row++) {
            dfs(board, row, 0);
            dfs(board, row, board[0].length - 1);
        }
        for (int col = 0; col < board[0].length; col++) {
            dfs(board, 0, col);
            dfs(board, board.length - 1, col);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == TEMP) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = TEMP;
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

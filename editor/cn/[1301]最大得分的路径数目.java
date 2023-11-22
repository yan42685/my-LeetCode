
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 面试不会考这么麻烦的题目的
 */
//class Solution {
//    private static final int OBSTACLE = -1;
//    private static final int MOD = (int) 1e9 + 7;
//    private List<String> board;
//    private int[][][] dp;
//
//    public int[] pathsWithMaxScore(List<String> board) {
//        this.board = board;
//        int n = board.size();
//        // dp[i][j][0] 表示最大得分， dp[i][j][1]表示路径数
//        dp = new int[n][n][2];
//        dp[n - 1][n - 1][0] = 0;
//        dp[n - 1][n - 1][0] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            int currScore = getNum(i, n - 1)
//            if (currScore == OBSTACLE) {
//                setObstacles(i, n - 1);
//            } else {
//                if (dp[i + 1][n - 1][0] == OBSTACLE) {
//                    setObstacles(i, n - 1);
//                } else {
//                    dp[i][n - 1][0] = (dp[i + 1][n - 1][0] + currScore) % MOD;
//                    dp[i][n - 1][1] = 1;
//                }
//            }
//        }
//        for (int j = n - 2; j >= 0; j--) {
//            int currScore = getNum(n - 1, j)
//            if (currScore == OBSTACLE) {
//                setObstacles(n - 1, j);
//            } else {
//                if (dp[n - 1][j + 1][0] == OBSTACLE) {
//                    setObstacles(n - 1, j);
//                } else {
//                    dp[n - 1][j][0] = (dp[n - 1][j + 1][0] + currScore) % MOD;
//                    dp[n - 1][j][1] = 1;
//                }
//            }
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                int currScore = getNum(i, j);
//                if (currScore == OBSTACLE) {
//                    setObstacles(i, j);
//                } else {
//                    int[] res = maxScoreAndCount(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]);
//                    if (res[1] == OBSTACLE) {
//                        setObstacles(i, j);
//                    } else {
//                        dp[i][j][0] = (res[0] + currScore) % MOD;
//                        dp[i][j][1] = res[1];
//                    }
//                }
//
//            }
//        }
//
//
//
//    }
//
//    private int getNum(int row, int col) {
//        char ch = board.get(row).charAt(col);
//        if (ch == 'X') {
//            return OBSTACLE;
//        } else if (ch == 'E') {
//            return 0;
//        } else {
//            return ch - '0';
//        }
//    }
//
//    private void setObstacles(int i, int j) {
//        dp[i][j][0] = OBSTACLE;
//        dp[i][j][1] = OBSTACLE;
//    }
//}
class Solution {
    private int mod = (int) 1e9 + 7;

    /*
       主要思想就是 保存最大得分路径的同时   该得分肯定由前一个状态中（左上  上 左）最大得分的路径转移
       而来, 若同时由两个状态转移过来  比如左上 和 上 都是1  则只需路径累加上到达前最大得分的路径数目即可
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.get(0).length();
        char[][] array = new char[n][];
        for (int i = 0; i < board.size(); i++) {
            array[i] = board.get(i).toCharArray();
        }
        //保存最大得分
        int[][] dp = new int[n + 1][n + 1];
        //保存到达该点最大得分的路径数目
        int[][] route = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            //初始为-1  表示不可达
            Arrays.fill(dp[i], -1);
        }
        //起始点E
        dp[1][1] = 0;
        //开始路线初始为1
        route[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (array[i - 1][j - 1] == 'X') continue;
                int score = 0;
                if (i == n && j == n)
                    score = 0;
                else
                    score = Character.getNumericValue(array[i - 1][j - 1]);
                //找前一个状态中（左上 上 左）的最大得分
                int pre_max = Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                //如果前一个状态是最大得分 则累加上到达该点的路径
                if (dp[i - 1][j - 1] == pre_max) route[i][j] = (route[i][j] + route[i - 1][j - 1]) % mod;
                if (dp[i][j - 1] == pre_max) route[i][j] = (route[i][j] + route[i][j - 1]) % mod;
                if (dp[i - 1][j] == pre_max) route[i][j] = (route[i][j] + route[i - 1][j]) % mod;
                //记录最大得分 -1表示不可达
                dp[i][j] = (pre_max == -1 ? pre_max : pre_max + score) % mod;

            }
        }
        return new int[]{dp[n][n] == -1 ? 0 : dp[n][n], route[n][n]};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

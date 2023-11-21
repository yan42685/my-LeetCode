
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 面试不会考这么麻烦的题目的
 */
class Solution {
    private static final int OBSTACLE = -1;
    private static final int MOD = (int) 1e9 + 7;
    private List<String> board;
    private int[][][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        int n = board.size();
        // dp[i][j][0] 表示最大得分， dp[i][j][1]表示路径数
        dp = new int[n][n][2];
        dp[n - 1][n - 1][0] = 0;
        dp[n - 1][n - 1][0] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int currScore = getNum(i, n - 1)
            if (currScore == OBSTACLE) {
                setObstacles(i, n - 1);
            } else {
                if (dp[i + 1][n - 1][0] == OBSTACLE) {
                    setObstacles(i, n - 1);
                } else {
                    dp[i][n - 1][0] = (dp[i + 1][n - 1][0] + currScore) % MOD;
                    dp[i][n - 1][1] = 1;
                }
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            int currScore = getNum(n - 1, j)
            if (currScore == OBSTACLE) {
                setObstacles(n - 1, j);
            } else {
                if (dp[n - 1][j + 1][0] == OBSTACLE) {
                    setObstacles(n - 1, j);
                } else {
                    dp[n - 1][j][0] = (dp[n - 1][j + 1][0] + currScore) % MOD;
                    dp[n - 1][j][1] = 1;
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int currScore = getNum(i, j);
                if (currScore == OBSTACLE) {
                    setObstacles(i, j);
                } else {
                    int[] res = maxScoreAndCount(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]);
                    if (res[1] == OBSTACLE) {
                        setObstacles(i, j);
                    } else {
                        dp[i][j][0] = (res[0] + currScore) % MOD;
                        dp[i][j][1] = res[1];
                    }
                }

            }
        }


    }

    private int getNum(int row, int col) {
        char ch = board.get(row).charAt(col);
        if (ch == 'X') {
            return OBSTACLE;
        } else if (ch == 'E') {
            return 0;
        } else {
            return ch - '0';
        }
    }

    private void setObstacles(int i, int j) {
        dp[i][j][0] = OBSTACLE;
        dp[i][j][1] = OBSTACLE;
    }
}
//class Solution {
//    private static final int OBSTACLE = -1;
//    private static final int MOD = (int) 1e9 + 7;
//    private List<String> board;
//
//    public int[] pathsWithMaxScore(List<String> board) {
//        this.board = board;
//        int n = board.size();
////        if (n == 2) {
////            return new int[]{0, 0};
////        }
//        int[][] dp = new int[n][n];
//        int[][] count = new int[n][n];
//        dp[n - 1][n - 1] = 0;
//        count[n - 1][n - 1] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            if (getNum(i, n - 1) == OBSTACLE) {
//                dp[i][n - 1] = OBSTACLE;
//                count[i][n - 1] = OBSTACLE;
//            } else {
//                dp[i][n - 1] = (dp[i + 1][n - 1] + getNum(i, n - 1)) % MOD;
//                count[i][n - 1] = 1;
//            }
//        }
//        for (int j = n - 2; j >= 0; j--) {
//            if (getNum(n - 1, j) == OBSTACLE) {
//                dp[n - 1][j] = OBSTACLE;
//                count[n - 1][j] = OBSTACLE;
//            } else {
//                dp[n - 1][j] = (dp[n - 1][j + 1] + getNum(n - 1, j)) % MOD;
//                count[n - 1][j] = 1;
//            }
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = n - 2; j >= 0; j--) {
//                if (getNum(i, j) == OBSTACLE) {
//                    dp[i][j] = OBSTACLE;
//                    count[i][j] = OBSTACLE;
//                } else {
//                    int[] res = getMaxAndCount(getNum(i, j), new int[]{dp[i + 1][j], count[i + 1][j]},
//                            new int[]{dp[i][j + 1], count[i][j + 1]},
//                            new int[]{dp[i + 1][j + 1], count[i + 1][j + 1]});
//                    if (res[1] == OBSTACLE) {
//                        dp[i][j] = OBSTACLE;
//                        count[i][j] = OBSTACLE;
//                    } else {
//                        dp[i][j] = res[0];
//                        count[i][j] = res[1];
//                    }
//                }
//            }
//        }
//        return getMaxAndCount(0,
//                new int[]{dp[1][0], count[1][0]}, new int[]{dp[0][1], count[0][1]},
//                new int[]{dp[1][1], count[1][1]});
//    }
//
//    private int getNum(int row, int col) {
//        char ch = board.get(row).charAt(col);
//        if (ch == 'X' || ch == 'E') {
//            return OBSTACLE;
//        } else {
//            return ch - '0';
//        }
//    }
//
//    /**
//     * 获取最大的score和总的count
//     */
//    private int[] getMaxAndCount(int currScore, int[]... pairs) {
//        int max = OBSTACLE;
//        int count = OBSTACLE;
//        for (int[] pair : pairs) {
//            if (pair[0] > max) {
//                // 每次更新最大值都重新记录count
//                count = pair[1];
//                max = pair[0];
//            } else if (pair[0] == max && max != OBSTACLE) {
//                count = (count + pair[1]) % MOD;
//            }
//        }
//        max = (max + currScore) % MOD;
//        return new int[]{max, count};
//    }
//}
//

//leetcode submit region end(Prohibit modification and deletion)

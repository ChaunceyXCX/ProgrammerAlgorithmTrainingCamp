package leetcode.editor.cn;// 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：n = 4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1535 👎 0


import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }


    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    // List<List<String>> result = new ArrayList<>();
    // List<String> path = new ArrayList<>();
    //
    // public List<List<String>> solveNQueens(int n) {
    //     backTracking(n, 1, new char[n][n]);
    //     return result;
    // }
    //
    // public void backTracking(int n, int row, char[][] chessBoard) {
    //     if (row == n) {  //row 在上一轮是加一进来的所以最后一轮组装完毕递归加一进来判断退出
    //         result.add(Arrsy2List(chessBoard, n));
    //         return;
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         if (isValid(i, row, chessBoard)) {
    //             chessBoard[row][i] = 'Q';
    //             backTracking(n, row + 1, chessBoard);
    //             chessBoard[row][i] = '.';
    //         }
    //     }
    // }
    //
    // private List<String> Arrsy2List(char[][] chessBoard, int n) {
    //     List<String> list = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         list.add(String.copyValueOf(chessBoard[i]));
    //     }
    //     return list;
    // }
    //
    // public boolean isValid(int col, int curRow, char[][] chessBoard) {
    //     // 同列
    //     for (int j = 0; j < curRow; j++) {
    //         if (chessBoard[j][col] == 'Q') {
    //             return false;
    //         }
    //     }
    //     // 同斜线
    //     // 45度
    //     // i=0的话就是同斜线第一个
    //     int j = curRow - 1;
    //     int i = col - 1;
    //     while (i >= 0 && j >= 0) {
    //         if (chessBoard[j--][i--] == 'Q') {
    //             return false;
    //         }
    //     }
    //     j = curRow - 1;
    //     i = col + 1;
    //     while (i < chessBoard.length && j >= 0) {
    //         if (chessBoard[j--][i++] == 'Q') {
    //             return false;
    //         }
    //     }
    //
    //     return true;
    // }


}
// leetcode submit region end(Prohibit modification and deletion)

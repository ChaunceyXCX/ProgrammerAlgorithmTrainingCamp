//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
// 
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
// 
//
//
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
//
// Related Topics 数组 回溯 矩阵 👍 1436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    public boolean backTracking(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.') continue; //当前桌标不是空位
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board,i,j, k)){
                        board[i][j] = k;
                        if (backTracking(board)) return true; //如果返回true表明找到正解直接返回
                        board[i][j] = '.';
                    }
                }
                return false; //如果1-9都不合适直接返回没有正确解法
            }
        }
        return true; //如果没有直接返回false 那么所所有节点填充完毕找到正确答案
    }

    public boolean isValid(char[][] board, int row, int col, char val){
        // 行
        for (char c : board[row]) {
            if (c == val){
                return false;
            }
        }
        // 列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val){
                return false;
            }
        }
        // 3*3小方格
        //小方格的第一个坐标
        int startX = 3*(row/3);
        int startY = 3*(col/3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startX+i][startY+j] == val){
                    return false;
                }
            }
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

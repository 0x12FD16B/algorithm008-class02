package nqueens_bit;

/**
 * N 皇后问题位运算解法
 *
 * @author David Liu
 */
public class Solution {

    private int count;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }
        // 获取当前皇后可以摆放的位置
        int bits = (~(col | na | pie)) & ((1 << n) - 1);

        while (bits > 0) {
            int p = bits & (-bits);
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1); // 打掉末位的 1
        }
    }
}

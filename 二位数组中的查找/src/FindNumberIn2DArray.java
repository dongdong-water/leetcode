import java.util.Set;
import java.util.TreeSet;
/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */


public class FindNumberIn2DArray {
    /**
     * 法一：这是我自己想的方法，特别慢
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        Set<Integer> set = new TreeSet<>();
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                set.add(matrix[i][j]);
            }
        }

        return set.contains(target);
    }
    /***
     * 法二：有点类似于排序二叉树的思想。因为左边的值一定比父亲小，右边的值一定比父亲大。
     * 其查找方法为：
     * 首先跟根节点比较，相同则找到。
     * 如果小于根节点，则到左子树中递归查找；
     * 如果大于根节点，则到右子树中递归查找；
     *
     * 回到这道题目：
     * 从右上角开始，
     * 如果当前元素（矩阵中的值）大于目标值，
     * 由题意可知，该目标值必然不能在其下方
     * 因为其下方是递增的
     * 所以移到左边一列
     * 如果当前元素小于目标值，由题意，其必不可能在左边，所以移到下边一列
     *
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

      if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
          return false;
      }
        int row = 0;
        int columns = matrix[0].length;
        int column = columns - 1;
        int rows = matrix.length;
      while(row < rows && column >= 0){
          int num = matrix[row][column];
          if(target == num){
              return true;

          }
          else if (target < num){
              column--;
          }
          else if (target > num){
              row++;
          }
      }
      return false;
    }
}




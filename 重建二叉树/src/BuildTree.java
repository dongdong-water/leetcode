/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树前序遍历的顺序为：
 * 先遍历根节点；
 * 随后递归地遍历左子树；
 * 最后递归地遍历右子树。
 *
 * 二叉树中序遍历的顺序为：
 * 先递归地遍历左子树；
 * 随后遍历根节点；
 * 最后递归地遍历右子树。
 */

/**
 * 这个算法里面有个很巧妙的地方：
 * 在中序遍历中对根节点进行定位时，
 * 一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，
 * 但这样做的时间复杂度较高。我们可以考虑使用哈希表来帮助我们快速地定位根节点。
 * 对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。
 * 在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。
 * 在此后构造二叉树的过程中，我们就只需要 O(1)O(1) 的时间对根节点进行定位了
 */

public class BuildTree {
        private Map<Integer, Integer> indexMap;

        //preorder_left 、 preorder_right 、 inorder_left 与 inorder_right 是边界
        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            //递归的退出条件（以左子树为例，其叶子节点的情况是 preorder_left = preorder_right,超过叶子节点以后， preorder_right不再增长，而preorder_left将+1，此时就退出了 ），
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            //preorder_root是根节点的位置，preorder[preorder_root]得到该位置的值，indexMap中存储的是中序遍历，其key是值，value是位置
            //所以这里就是找到了中序遍历中根节点的位置
            int inorder_root = indexMap.get(preorder[preorder_root]);
            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            // 中序遍历得到根节点以后，可以区分为左右两棵树
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            // 前序遍历的第一个就是根节点，因为用掉了，所以preorder_left是preorder_left+1
            // 这里是递归的在找左子树的根节点，所以preorder_right是preorder_left+size_left_subtree
            // 对于中序遍历来说，其由于构造的是左子树，所以起始并没有变化
            // 左子树的中序遍历的右边是根的位置的左边那个元素所以是inorder_root - 1
            root.left = myBuildTree(preorder, inorder, preorder_left + 1,
                                    preorder_left + size_left_subtree,
                                    inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            //root.right就是除去根节点，除去左子树的情况
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            //一层一层的将根节点返回
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                //注意这里的key是中序遍历的值，value是中序遍历中该值的位置
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
}

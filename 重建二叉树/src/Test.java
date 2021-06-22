public class Test {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder,inorder);
        //这里如果想要将这棵树画出来，需要用到队列，参考力扣102题，暂时还没写
    }

}

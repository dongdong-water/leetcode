import java.util.HashMap;
import java.util.Map;

public class BuildTreeByMyself {
    Map<Integer,Integer> indexMap ;
    public TreeNode myBuildTree(int[] preorder , int[] inorder , int preorder_left , int preorder_right , int inorder_left , int inorder_right){
        if(preorder_left > preorder_right){
            return null ;
        }
        int inorder_index_root = indexMap.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int left_subtree_size = inorder_index_root - inorder_left;

        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+left_subtree_size,inorder_left,inorder_index_root-1);

        root.right = myBuildTree(preorder,inorder,preorder_left+left_subtree_size+1,preorder_right,inorder_index_root+1,inorder_right);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        indexMap = new HashMap<>();
        for(int i =0; i< size ; i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,size-1,0,size-1);
    }
}

class Solution {
boolean isBalanced = true;

public boolean isBalanced(TreeNode root) {
    
    isBalan(root);
    return isBalanced;
}

int isBalan(TreeNode root){
    if(root == null){
        return 0;
    }
    
    int left = isBalan(root.left);
    int right = isBalan(root.right);
    
    if(isBalanced && Math.abs(left - right) > 1){
        isBalanced = false;
    }
    
    return Math.max(left, right)+1;
}
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
         if(root ==null)
         {
             return true;
         }
        else {
            return helper(root.left,root.right);
        }
    }
    public boolean helper(TreeNode left,TreeNode right)
    {
        if(left==null&&right ==null)
        {
            return true;
        }
        else if(left==null||right==null)
        {
            return false;
        }
        else 
        {
            if(left.val==right.val)
            {
                boolean one = helper(left.left,right.right);
                boolean two = helper(left.right,right.left);
                return one && two;
            }
            return false ;
        }
    }
}
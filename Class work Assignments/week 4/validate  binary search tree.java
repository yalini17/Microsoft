class Solution {

	ArrayList<Integer> res = new ArrayList<>();
    public void inOrder(TreeNode root){  
		if(root!=null)
        { 
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }     
    }
	
    public boolean isValidBST(TreeNode root) {
	
        inOrder(root);
        for(int i=0;i<res.size()-1;i++)
        {
            if(res.get(i)>=res.get(i+1))     
                return false;                      
        }
        return true;
    }
}

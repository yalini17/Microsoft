class Solution {
public List postorderTraversal(TreeNode root) {
ArrayList list = new ArrayList<>();
helper(root, list);
return list;
}
public void helper(TreeNode root, ArrayList list){

    if(root == null)return;
    helper(root.left, list);
    helper(root.right, list);
    list.add(root.val);
}
}

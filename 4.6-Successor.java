//TreeNode inorderSucc(TreeNode n){
    if (n == null) return null;
    
    /*Found right children: return leftmost node od right subtree.*/
    if (n.right != null){
        return leftMostChild(n.right);
    }
    else{
        TreeNode q = n;
        TreeNode x = q.parent;
        //go up until we are on the left instead of right.
        while( x != null && x.left != q){
            q = x;
            x = x.parent;
        }
        return x;
    }
}

TreeNode leftMostChild(TreeNode n){
    if(n = null){
        return null;
    }
    while(n.left != null){
        n = n.left;
    }
    return n;
}
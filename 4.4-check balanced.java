//Solution 1:based on the definition of balanced tree.

int getHeight(TreeNode root){
    if (root == null) return -1;  //Base Case;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

boolean isBalanced(TreeNode root){
    if (root == null) return true; //Base Case
    int heightDiff = getHeight(root.left) - getHeight(root.right);
    if(Math.abs(heightDiff) > 1){
        return false;
    }
    else{
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

/*Solution 1 is not efficient, the algorithm is O(NlogN) since each node is touched once per node above it.
 *We have to cut some of the calls to getHeight.*/


// Solution 2: improved algorithm.

int checkHeight(TreeNode root){
    if(root ==null) return -1;
    
    int leftHeight = checkHeight(root.left);
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //pass error up
    
    int rightHeight = checkHeight(root.right);
    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //pass error up
    
    int heightDiff = leftHeight - rightHeight;
    
     if(Math.abs(heightDiff) > 1){
        return Integer.MIN_VALUE; //found error , pass it back
    }
    else{
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}

boolean isBalanced (TreeNode root){
    return checkHeight(root) != Integer.MIN_VALUE;
}

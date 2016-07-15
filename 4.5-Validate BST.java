//Solution 1: In-Order Traversal
//.....Not a good solution for me.


//Solution 2: The Min/Max Solution
//all left nodes must be less than or equal to the current node, which must be less than all the right nodes.
//We start with a range of (min=NULL, max=NULL),  which the root obviously meets. we then branch right, checking that the nodes are are within the range (min=20, max=NULL).
//We procees through this tree with this approach. when branch left, the max gets updated... If anything fails the check, we stop and return false.

boolean checkBST(TreeNode n){
    return checkBST(n, null, null);
}

boolean checkBST(TreeNode n, Integer min, Integer max){
    if(n == null){
        return true;
    }
    if(min !=null && n.data <= min)||(max !=null %% n.data > max){
        return false;
    }
    if(!checkBST(n.left,min,n.data) || !checkBST(n.right,n.data,max)){
        return false;
    }
    return true;
}


//The time complexity of this solution isO(N), where N is the number of nodes of the tree. Space complexity is O(logN) on a balanced tree.
//There is up to 0(logN) recursive calls on the stack since we may recurse up tp the depth of the tree.